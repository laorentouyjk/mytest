package com.yijiankang.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr
 * @title: ConfigController
 * @projectName mytest
 * @description: TODO
 * @date 2019/6/2811:14
 */
@RestController
public class ConfigController {
   // @Value("${server.port}")
   @Value("${spring.application.name}")
    private String port;

    @GetMapping("/getValue")
    public String getValue(){
        return port;
    }

}
