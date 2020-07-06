package com.example.liang.setting.dao.mapper.ext;

import com.example.liang.setting.dao.dataObject.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/7/1 10:43
 */
public interface ExtUserMapper {

    User selectByEmail(@Param("email") String userId);

    String selectPasswordByUserId(@Param("userId") String userId);
}
