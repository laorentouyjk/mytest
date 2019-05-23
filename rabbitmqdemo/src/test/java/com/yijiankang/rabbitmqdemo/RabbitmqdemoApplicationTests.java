package com.yijiankang.rabbitmqdemo;

import com.yijiankang.rabbitmqdemo.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqdemoApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testProducerMq(){
        for (int i=0;i<5;i++){
            String message = "hello,this is a message"+i;
            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFO,"queue.email.sms",message);
            System.out.println("发送的消息为"+message);
        }
    }

}
