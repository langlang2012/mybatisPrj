package org.chen.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import org.chen.mybatis.po.User;

/**
 * User: chendf@djcars.cn
 * Date: 2018/6/12 14:57
 * Version: 2.0.4
 * Description:.
 */
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE id=#{id}")
    User findUserById(int id);
}
