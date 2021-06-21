package com.wly.rabbitmq.springbootorderrabbitmqconsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "duanxin.fanout.queue")
public class FanoutDuanxinConsumer {
    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("duanxin fahnout ---接受到了订单信息"+message);
    }
}
