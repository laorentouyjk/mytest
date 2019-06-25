package com.yijiankang.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("eureka-client")
public interface HelloService {


}
