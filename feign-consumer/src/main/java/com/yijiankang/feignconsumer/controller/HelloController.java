package com.yijiankang.feignconsumer.controller;

import com.yijiankang.feignconsumer.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String helloTest(){
        return helloService.Hello();
    }
}
