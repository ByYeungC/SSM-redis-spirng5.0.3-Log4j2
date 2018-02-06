package com.zezon.mail.test;


import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.zezon.mail.service.UserService;



/**  
    * @Title: BeanTest.java
    * @Package 
    * @Description: TODO(测试SSM，redis)
    * @author mr.yeungc
    * @date 2018年1月30日
    * @version V1.0  
    */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath*:/config/springmvc.xml","classpath*:/config/applicationContext-dao.xml","classpath*:/config/SqlMapConfig.xml","classpath*:/config/applicationContext-redis.xml"})public class BeanTest extends AbstractJUnit4SpringContextTests{
    @Resource(name="userService")
    private UserService userService;
    
    @SuppressWarnings("unused")
    private static Logger logger = LogManager.getLogger(BeanTest.class);   
    
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Test
    public void getUser() {
        System.out.println(userService.findUserList().get(4).getUsername());
    }
    
    @Test
    public void test(){
        redisTemplate.opsForValue().set("hello", "hello");
//        redisTemplate.opsForValue().set("hello", "hello",10, TimeUnit.SECONDS);//设置过时时间
        String str = (String) redisTemplate.opsForValue().get("hello");
//        redisTemplate.opsForValue().getOperations().delete("hello");
        
        System.out.println(str);
    }

}
