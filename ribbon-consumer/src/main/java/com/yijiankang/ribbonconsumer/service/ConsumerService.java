package com.yijiankang.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

   @HystrixCommand(fallbackMethod = "helloFailBack")
    public String helloService(){
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello/helloTest",String.class).getBody();
    }

    public String helloFailBack(){
        return "调用出错了";
    }
}
