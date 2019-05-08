package com.yijiankang.redisdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试redis")
@RestController
@RequestMapping("api")
public class RedisController {

    @ApiOperation(value="测试redis应用")
    @PostMapping(value="/testRedis")

    public void  TestRedis(){
        System.out.println("1111");

    }

}
