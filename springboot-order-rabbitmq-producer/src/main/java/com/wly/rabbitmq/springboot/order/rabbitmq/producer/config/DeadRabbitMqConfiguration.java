package com.wly.rabbitmq.springboot.order.rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeadRabbitMqConfiguration {
    //1.声明注册fanout模式的交换机
    @Bean
    public DirectExchange deaddirectExchange(){
        return  new DirectExchange("dead_direct_exchange",true,false);
    }


    //2.声明队列 sms.fanout.queue email.fanout.queue  duanxin.fanout.queue
    @Bean
    public Queue directdeadQueue(){

        return new Queue("dead.message.queue",true);
    }

    @Bean
    public Binding deadBinging(){
        return BindingBuilder.bind(directdeadQueue()).to(deaddirectExchange()).with("dead");
    }

}
