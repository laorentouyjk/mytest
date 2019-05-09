package com.yijiankang.redisdemo.controller;

import com.yijiankang.redisdemo.redisconfig.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试redis")
@RestController
@RequestMapping("api")
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtils redisUtils;


    @ApiOperation(value="测试redis应用")
    @PostMapping(value="/testRedis")
    public void  TestRedis(){
        redisTemplate.opsForValue().set("aaa","1111");
        redisUtils.set("bbb","222");
        System.out.println("1111");

    }

}
