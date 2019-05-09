package com.yijiankang.websocketdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author Mr
 * @title: WebsocketConfig
 * @projectName redisdemo
 * @description: TODO
 * @date 2019/5/914:33
 */
@Configuration
public class WebsocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
