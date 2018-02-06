package com.zezon.mail.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zezon.mail.entity.User;
import com.zezon.mail.service.UserService;
/**
 * 
    * @ClassName: DemoController
    * @Description: TODO(controller)
    * @author mr.yeungc
    * @date 2018年1月30日
    * @version V1.0
    *
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    
        @Autowired
        private UserService userService;
        @RequestMapping("/index")
        public String index(){
        return "demo";
    }
    
    @RequestMapping("/all")
    public ModelAndView all() {
        redisTemplate.opsForValue().set("hello", "hello");
        String str = (String) redisTemplate.opsForValue().get("hello");
        logger.info("Demo========="+str);
        List<User> userList = userService.findUserList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("all");
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }
}
