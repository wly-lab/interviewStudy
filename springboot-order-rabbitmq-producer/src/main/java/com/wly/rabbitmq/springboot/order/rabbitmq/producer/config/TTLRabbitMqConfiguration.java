package com.wly.rabbitmq.springboot.order.rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TTLRabbitMqConfiguration {
    //1.声明注册fanout模式的交换机
    @Bean
    public DirectExchange ttldirectExchange(){
        return  new DirectExchange("ttl_direct_exchange",true,false);
    }

    //2.声明队列 sms.fanout.queue email.fanout.queue  duanxin.fanout.queue
    @Bean
    public Queue directttlQueue(){
        Map<String,Object> args=new HashMap<>();
        args.put("x-message-ttl",5000);
        args.put("x-dead-letter-exchange","dead_direct_exchange");
        args.put("x-dead-letter-routing-key","dead");//fanout模式不需要配置
        return new Queue("ttl.direct.queue",true,false,false,args);
    }

    //2.声明队列 sms.fanout.queue email.fanout.queue  duanxin.fanout.queue
    @Bean
    public Queue directttlMessageQueue(){

        return new Queue("ttl.message.queue",true);
    }

    @Bean
    public Binding ttlBinging(){
        return BindingBuilder.bind(directttlQueue()).to(ttldirectExchange()).with("ttl");
    }


    @Bean
    public Binding ttlMeassageBinging(){
        return BindingBuilder.bind(directttlMessageQueue()).to(ttldirectExchange()).with("ttlmessage");
    }

}
