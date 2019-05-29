package com.yijiankang.recievemq.config;

import com.rabbitmq.client.Channel;
import com.yijiankang.rabbitmqdemo.config.RabbitmqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author Mr 工作队列模式  轮询消费消息   不会有重复的消费消息
 * @title: RecieveMq
 * @projectName mytest
 * @description: TODO
 * @date 2019/5/2211:30
 */
@Component
public class RecieveMqWorkQueue {
    //监听email队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_EMAIL})
    public void receive_email(String msg,Message message,Channel channel){
        System.out.println("第一个"+msg+"email");
    }

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_EMAIL})
    public void receive_email1(String msg,Message message,Channel channel){
        System.out.println("第二个"+msg+"email");
    }
    //监听sms队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_SMS})
    public void receive_sms(String msg,Message message,Channel channel){
        System.out.println(msg+"sms");
    }

}
