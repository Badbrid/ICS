package com.example.liang.setting.service;

import com.example.liang.setting.dto.UserDTO;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/29 15:12
 */
public interface UserService {

    UserDTO getUserDto(String userId);

    UserDTO getUserDtoByEmail(String userId);

    boolean checkPassword(String userId, String password);
}
