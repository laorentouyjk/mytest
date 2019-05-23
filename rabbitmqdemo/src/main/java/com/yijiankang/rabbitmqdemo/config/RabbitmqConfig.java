package com.yijiankang.rabbitmqdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr
 * @title: RabbitmqConfig
 * @projectName mytest
 * @description: TODO
 * @date 2019/5/229:23
 */
@Configuration
public class RabbitmqConfig {
    public static final String QUEUE_SMS="queue_sms";
    public static final String QUEUE_EMAIL="queue_email";
    public static final String EXCHANGE_TOPICS_INFO="exchange_topics_info";

    /**
     * 交换机配置
     * ExchangeBuilder提供了fanout、direct、topic、header交换机类型的配置
     * @return the exchange
     */
    @Bean(EXCHANGE_TOPICS_INFO)
    public Exchange exchange_topic_info(){
        //durable(true)持久化，消息队列重启后交换机仍然存在
       return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS_INFO).durable(true).build();
    }

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

    /**
     * 绑定交换机 队列
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bind_exchange_queue_sms(@Qualifier(QUEUE_SMS) Queue queue,@Qualifier(EXCHANGE_TOPICS_INFO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("#.sms.#").noargs();
    }

    /**
     * b绑定队列交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bind_exchange_queue_email(@Qualifier(QUEUE_EMAIL) Queue queue,@Qualifier(EXCHANGE_TOPICS_INFO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("queue.email.#").noargs();
    }


}
