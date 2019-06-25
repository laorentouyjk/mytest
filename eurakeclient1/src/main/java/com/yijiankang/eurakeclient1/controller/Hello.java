package com.yijiankang.eurakeclient1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {

    @RequestMapping(value = "/helloTest",method = RequestMethod.GET)
    public String helloTest(){
        System.out.println("111111");
        return "1111111";
    }
}
