package com.example.liang.setting.dao.mapper.ext;

import com.example.liang.setting.dao.dataObject.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/6/29 17:20
 */
public interface ExtRoleMapper {

    List<Role> selectById(@Param("list") List<String> roleIds);
}
