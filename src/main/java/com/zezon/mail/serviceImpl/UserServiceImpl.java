package com.zezon.mail.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zezon.mail.entity.User;
import com.zezon.mail.mapper.UserMapper;
import com.zezon.mail.service.UserService;


/**
 * 
    * @ClassName: UserServiceImpl
    * @Description: TODO(service实现类)
    * @author mr.yeungc
    * @date 2018年1月30日
    * @version V1.0
    *
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper users;

    public List<User> findUserList() {
        return users.selectUser();
    }
}
