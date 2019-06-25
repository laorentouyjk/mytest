package com.yijiankang.eurakeclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Eurakeclient1Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurakeclient1Application.class, args);
    }

}
