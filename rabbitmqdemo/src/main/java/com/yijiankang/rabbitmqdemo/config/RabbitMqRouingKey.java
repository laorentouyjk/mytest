package com.yijiankang.rabbitmqdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr
 * @title: RabbitMqPublish
 * @projectName mytest
 * @description: TODO
 * @date 2019/5/299:58
 */
@Configuration
public class RabbitMqRouingKey {
    public static final String QUEUE_SMS="queue_sms_key";
    public static final String QUEUE_EMAIL="queue_email_key";
    public static final String EXCHANGE_TOPICS_INFO="exchange_topics_info_key";

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
     * 交换机配置
     * ExchangeBuilder提供了fanout、direct、topic、header交换机类型的配置
     * @return the exchange
     */
    @Bean(EXCHANGE_TOPICS_INFO)
    public Exchange exchange_topic_info(){
        //广播模式   消息会发送给 所有与交换机绑定的队列
        return ExchangeBuilder.directExchange(EXCHANGE_TOPICS_INFO).durable(true).build();
    }

    /**
     * 绑定交换机 队列
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bind_exchange_queue_sms_key(@Qualifier(QUEUE_SMS) Queue queue, @Qualifier(EXCHANGE_TOPICS_INFO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("sms").noargs();
    }

    /**
     * b绑定队列交换机
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bind_exchange_queue_email_key(@Qualifier(QUEUE_EMAIL) Queue queue,@Qualifier(EXCHANGE_TOPICS_INFO) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("email").noargs();
    }

}
