package com.example.liang.setting.dao.mapper.ext;

import com.example.liang.setting.dao.dataObject.UserRole;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/29 16:01
 */
public interface ExtUserRoleMapper {


    List<UserRole> selectByUserId1(@Param("userId") String userId);

}
