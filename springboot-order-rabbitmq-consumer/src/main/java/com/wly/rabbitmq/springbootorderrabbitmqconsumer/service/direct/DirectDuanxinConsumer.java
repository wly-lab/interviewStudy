package com.wly.rabbitmq.springbootorderrabbitmqconsumer.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "duanxin.direct.queue")
public class DirectDuanxinConsumer {
    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("duanxin direct ---接受到了订单信息"+message);
    }
}
