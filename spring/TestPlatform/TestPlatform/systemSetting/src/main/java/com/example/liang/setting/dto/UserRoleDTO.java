package com.example.liang.setting.dto;

import com.example.liang.setting.dao.dataObject.Role;
import com.example.liang.setting.dao.dataObject.UserRole;
import lombok.Data;

import java.util.List;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/28 16:10
 */
@Data
public class UserRoleDTO {

    private String userId;
    private List<Role> roles;
    private List<UserRole> userRoles;
    private static final long serialVersionUID = 1L;
}
