package com.yijiankang.websocketdemo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr
 * @title: SocketTopic
 * @projectName redisdemo
 * @description: TODO
 * @date 2019/5/139:38
 */
@RestController
public class SocketTopic {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @ApiOperation(value = "发送订阅消息")
    @RequestMapping(value = "/sendMessage",method = RequestMethod.POST)
    public void  SendMessage(){
        simpMessagingTemplate.convertAndSend("/topic/20","发送消息");
    }


}
