package com.example.liang.setting.commons.security;

import com.example.liang.setting.commons.il8n.ConvertLanguage;
import com.example.liang.setting.commons.utils.ShiroSessionUtils;
import com.example.liang.setting.dao.dataObject.User;
import com.example.liang.setting.dto.UserDTO;
import com.example.liang.setting.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/29 11:38
 */
public class MyShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    UserService userService;

    @Autowired
    ConvertLanguage convertLanguage;

    @Value("{$run.model:release}")
    private String runModel;

    /**
     * 权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String msg = "";
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userId = usernamePasswordToken.getUsername();
        String password = String.valueOf(usernamePasswordToken.getPassword());
        UserDTO userDTO = userService.getUserDto(userId);
        if(userDTO  == null){
            userDTO = userService.getUserDtoByEmail(userId);
            if(userDTO == null){
                msg = "用户不存在" + userId;
                logger.warn(msg);
                throw new UnknownAccountException(convertLanguage.get("user_not_exist") + userId);
            }
            userId = userDTO.getId();
        }
        //本地免登录
        if(StringUtils.equals("local",runModel)){
            ShiroSessionUtils.putUser(userDTO);
            return new SimpleAuthenticationInfo(userId,password,getName());
        }
        //验证密码
        if(!userService.checkPassword(userId,password)){
            throw new IncorrectCredentialsException(convertLanguage.get("password_is_incorrect"));
        }
        ShiroSessionUtils.putUser(userDTO);
        return new SimpleAuthenticationInfo(userId,password,getName());
    }

}
