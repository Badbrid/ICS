package com.example.liang.setting.dto;

import com.example.liang.setting.dao.dataObject.Role;
import com.example.liang.setting.dao.dataObject.UserRole;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/28 16:02
 */
@Data
public class UserDTO {
    private String id;

    private String name;

    private String email;

    private String phone;

    private String status;

    private Long createTime;

    private Long updateTime;

    private String language;

    private String lastWorkspaceId;

    private String lastOrganizationId;

    private List<Role> roles = new ArrayList<>();

    private List<UserRole> userRoles = new ArrayList<>();

    private static final long serialVersionUID = 1L;

}
