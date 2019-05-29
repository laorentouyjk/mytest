package com.yijiankang.rabbitmqdemo;

import com.yijiankang.rabbitmqdemo.config.RabbitMqPublish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Mr
 * @title: RabbitMqWorkQueue
 * @projectName mytest
 * @description: TODO
 * @date 2019/5/2410:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqWorkPublish {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testProducerMq(){
        for (int i=0;i<5;i++){
            String message = "hello,this is a message"+i;
            //推送消息  指定交换机  routingkey  消息内容
            rabbitTemplate.convertAndSend(RabbitMqPublish.EXCHANGE_TOPICS_INFO,"",message);
            System.out.println("发送的消息为"+message);
        }
    }
}
