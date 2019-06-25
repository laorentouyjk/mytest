package com.yijiankang.ribbonconsumer.Controller;

import com.yijiankang.ribbonconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "/helloConsumer",method = RequestMethod.GET)
    public String helloConsumer(){
       return consumerService.helloService();
    }
}
