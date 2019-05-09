package com.yijiankang.websocketdemo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author Mr
 * @title: SocketController
 * @projectName redisdemo
 * @description: TODO
 * @date 2019/5/915:52
 */
@RestController
@RequestMapping("/checkcenter")
public class SocketController {

    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }
    //推送数据接口
    @PostMapping("/socket/push/{cid}")
    public  void  pushToWeb(@PathVariable String cid,String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();

        }
   }
}