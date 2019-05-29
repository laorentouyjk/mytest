package com.yijiankang.rabbitmqdemo.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 工作队列模式 声明队列
 * @author Mr
 * @title: RabbitmqConfig
 * @projectName mytest
 * @description: TODO
 * @date 2019/5/229:23
 */
@Configuration
public class RabbitmqWorkQueueConfig {
    public static final String QUEUE_SMS="queue_sms_work_queue";
    public static final String QUEUE_EMAIL="queue_email_work_queue";



    /**
     * 声明短信队列
     * @return
     */
    @Bean(QUEUE_SMS)
    public Queue queue_sms(){
        Queue queue = new Queue(QUEUE_SMS);
        return queue;
    }

    /**
     * 声明邮件队列
     * @return
     */
    @Bean(QUEUE_EMAIL)
    public Queue queue_email(){
        Queue queue = new Queue(QUEUE_EMAIL);
        return queue;
    }



}
