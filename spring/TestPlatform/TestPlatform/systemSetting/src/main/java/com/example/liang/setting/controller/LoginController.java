package com.example.liang.setting.controller;

import com.example.liang.setting.controller.request.LoginRequest;
import com.example.liang.setting.controller.response.DataResult;
import com.example.liang.setting.dao.dataObject.UserRole;
import com.example.liang.setting.dto.UserDTO;
import com.example.liang.setting.commons.il8n.ConvertLanguage;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.liang.setting.commons.constants.SessionConstants.ATTR_USER;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/28 14:26
 */
@RestController
@ResponseBody
public class LoginController {

    @Autowired
    ConvertLanguage convertLanguage;

    @GetMapping("isLogin")
    public DataResult isLogin(){
        boolean login = SecurityUtils.getSubject().isAuthenticated();
        if(login){
            return DataResult.success(LocaleContextHolder.getLocale());
        }
        return DataResult.error("");
    }

    @PostMapping("/signin")
    public DataResult login(@RequestBody LoginRequest loginRequest){
        String msg;
        String username = StringUtils.trim(loginRequest.getUsername());
        String password = StringUtils.trim(loginRequest.getPassword());
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return DataResult.error("用户名或密码不能为空");
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                UserDTO userDTO = (UserDTO) subject.getSession().getAttribute(ATTR_USER);
                if(StringUtils.isEmpty(userDTO.getLastOrganizationId())){
                    List<UserRole> userRoles = userDTO.getUserRoles();
                    List<UserRole> test = userRoles.stream().filter(userRole -> userRole.getRoleId().startsWith("test")).collect(Collectors.toList());
                    List<UserRole> org = userRoles.stream().filter(userRole -> userRole.getRoleId().startsWith("org")).collect(Collectors.toList());
                    if(test.size() > 0){
                        //TODO
                    }else if(org.size() > 0){
                        //TODO
                    }
                }
                return DataResult.success(subject.getSession().getAttribute("user"));
            }else {
                return DataResult.error(convertLanguage.get("login_fail"));
            }
        } catch (ExcessiveAttemptsException e){
            msg = convertLanguage.get("excessive_attempts");
        } catch (LockedAccountException e) {
            msg = convertLanguage.get("user_locked");
        } catch (DisabledAccountException e) {
            msg = convertLanguage.get("user_has_been_disabled");
        } catch (ExpiredCredentialsException e) {
            msg = convertLanguage.get("user_expires");
        } catch (AuthenticationException e) {
            msg = e.getMessage();
        } catch (UnauthorizedException e) {
            msg = convertLanguage.get("not_authorized") + e.getMessage();
        }
        return DataResult.error(msg);
    }

    @GetMapping("loginOut")
    public DataResult loginOut(){
        SecurityUtils.getSubject().logout();
        return DataResult.success("");
    }
}
