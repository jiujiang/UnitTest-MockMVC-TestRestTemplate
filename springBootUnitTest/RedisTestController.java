package com.example.demo.springBootUnitTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {


    @Autowired
    public StringRedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public String testRedis(){
        redisTemplate.opsForValue().set("Hello","2");
        return "hello";
    }

    @PostMapping("/tango")
    public String testTango(){
       return "hellopost";
    }
}
