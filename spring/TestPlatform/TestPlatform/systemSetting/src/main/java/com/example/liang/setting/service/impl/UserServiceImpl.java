package com.example.liang.setting.service.impl;

import com.example.liang.setting.commons.constants.UserStatus;
import com.example.liang.setting.commons.exception.BusinessException;
import com.example.liang.setting.commons.il8n.ConvertLanguage;
import com.example.liang.setting.commons.utils.SecretUtil;
import com.example.liang.setting.dao.dataObject.Role;
import com.example.liang.setting.dao.dataObject.User;
import com.example.liang.setting.dao.dataObject.UserRole;
import com.example.liang.setting.dao.mapper.UserMapper;
import com.example.liang.setting.dao.mapper.ext.ExtRoleMapper;
import com.example.liang.setting.dao.mapper.ext.ExtUserMapper;
import com.example.liang.setting.dao.mapper.ext.ExtUserRoleMapper;
import com.example.liang.setting.dto.UserDTO;
import com.example.liang.setting.dto.UserRoleDTO;
import com.example.liang.setting.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/29 15:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ExtUserRoleMapper extUserRoleMapper;

    @Autowired
    ExtRoleMapper extRoleMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ExtUserMapper extUserMapper;

    @Autowired
    ConvertLanguage convertLanguage;

    @Override
    public UserDTO getUserDto(String userId) {

        User user = userMapper.selectByPrimaryKey(userId);

        if (userId == null) {
            return null;
        }
        if (StringUtils.equals(user.getStatus(), UserStatus.DISABLED)) {
            throw new DisabledAccountException();
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        UserRoleDTO userRoleDTO = getUserRole(user.getId());
        userDTO.setUserRoles(Optional.ofNullable(userRoleDTO.getUserRoles()).orElse(new ArrayList<>()));
        userDTO.setRoles(Optional.ofNullable(userRoleDTO.getRoles()).orElse(new ArrayList<>()));
        return userDTO;
    }

    @Override
    public UserDTO getUserDtoByEmail(String userId) {
        User user = extUserMapper.selectByEmail(userId);
        if(user == null){
            return null;
        }
        if (StringUtils.equals(user.getStatus(),UserStatus.DISABLED)){
            throw new DisabledAccountException();
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        UserRoleDTO userRoleDTO = getUserRole(userId);
        userDTO.setRoles(Optional.ofNullable(userRoleDTO.getRoles()).orElse(new ArrayList<>()));
        userDTO.setUserRoles(Optional.ofNullable(userRoleDTO.getUserRoles()).orElse(new ArrayList<>()));
        return userDTO;
    }

    @Override
    public boolean checkPassword(String userId, String password) {
        if(StringUtils.isBlank(password)){
            throw new BusinessException(convertLanguage.get("password_is_null"));
        }
        String passwd = extUserMapper.selectPasswordByUserId(userId);
        if(StringUtils.equals(passwd, SecretUtil.MD5(password))){
            return true;
        }
        return false;
    }

    private UserRoleDTO getUserRole(String userId) {
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        List<UserRole> userRoles = extUserRoleMapper.selectByUserId1(userId);
        if(CollectionUtils.isEmpty(userRoles)){
            return userRoleDTO;
        }
        userRoleDTO.setUserRoles(userRoles);
        List<String> roleId = userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());
        List<Role> roles = extRoleMapper.selectById(roleId);
        userRoleDTO.setRoles(roles);
        return userRoleDTO;
    }

}
