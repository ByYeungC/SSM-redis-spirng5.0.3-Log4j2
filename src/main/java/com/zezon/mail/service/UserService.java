package com.zezon.mail.service;

import java.util.List;

import com.zezon.mail.entity.User;


/**
 * 
    * @ClassName: UserService
    * @Description: TODO(service接口层)
    * @author mr.yeungc
    * @date 2018年1月30日
    * @version V1.0
    *
 */
public interface UserService {
    public List<User> findUserList();
}
