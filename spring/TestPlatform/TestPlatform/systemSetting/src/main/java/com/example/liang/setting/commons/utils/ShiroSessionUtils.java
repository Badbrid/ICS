package com.example.liang.setting.commons.utils;

import com.example.liang.setting.dto.UserDTO;
import org.apache.shiro.SecurityUtils;

import static com.example.liang.setting.commons.constants.SessionConstants.ATTR_USER;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/7/2 18:18
 */
public class ShiroSessionUtils {

    public static void putUser(UserDTO userDTO){
        SecurityUtils.getSubject().getSession().setAttribute(ATTR_USER,userDTO);
    }


}
