package com.zezon.mail.mapper;

import java.util.List;

import com.zezon.mail.entity.User;

/**
 * 
    * @ClassName: UserMapper
    * @Description: TODO(DAOc层)
    * @author mr.yeungc
    * @date 2018年1月30日
    * @version V1.0
    *
 */
public interface UserMapper {
    List<User> selectUser();
}
