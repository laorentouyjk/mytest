package com.yijiankang.eurakeclient.Hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {

    @RequestMapping(value="/helloTest",method = RequestMethod.GET)
    public String helloTest(){
        System.out.println("222");
        return "222";
    }
}
