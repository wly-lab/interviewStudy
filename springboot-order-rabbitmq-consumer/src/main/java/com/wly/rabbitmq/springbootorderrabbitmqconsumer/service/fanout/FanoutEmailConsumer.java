package com.wly.rabbitmq.springbootorderrabbitmqconsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "email.fanout.queue")
public class FanoutEmailConsumer {
    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("email fanout ---接受到了订单信息"+message);

    }
}
