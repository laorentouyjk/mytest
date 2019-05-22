package com.yijiankang.recievemq.config;

import com.yijiankang.rabbitmqdemo.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;
import com.rabbitmq.client.Channel;




/**
 * @author Mr
 * @title: RecieveMq
 * @projectName mytest
 * @description: TODO
 * @date 2019/5/2211:30
 */
@Component
public class RecieveMq {
    //监听email队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_EMAIL})
    public void receive_email(String msg,Message message,Channel channel){
        System.out.println(msg);
    }
    //监听sms队列
    @RabbitListener(queues = {RabbitmqConfig.QUEUE_SMS})
    public void receive_sms(String msg,Message message,Channel channel){
        System.out.println(msg);
    }

}
