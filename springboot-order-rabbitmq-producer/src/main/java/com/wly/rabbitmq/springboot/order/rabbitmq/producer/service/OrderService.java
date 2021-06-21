package com.wly.rabbitmq.springboot.order.rabbitmq.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 *
 * 模拟用户下单
 */
@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(String userid,String productid,int num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId= UUID.randomUUID().toString();
        System.out.println("订单生成成功："+orderId);
        //3.通过mq来完成消息的分发
        //参数1 交换机 参数2：路由key/queue队列名称 参数3：消息内容
        String exchangeName="fanout_order_exchange";
        String routingKey="";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId );
    }
    public void makeOrderDirect(String userid,String productid,int num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId= UUID.randomUUID().toString();
        System.out.println("订单生成成功："+orderId);
        //3.通过mq来完成消息的分发
        //参数1 交换机 参数2：路由key/queue队列名称 参数3：消息内容
        String exchangeName="direct_order_exchange";
        rabbitTemplate.convertAndSend(exchangeName,"email",orderId );
        rabbitTemplate.convertAndSend(exchangeName,"duanxin",orderId );
    }

    public void makeOrderTopic(String userid,String productid,int num){
        //1.根据商品ID查询库存是否充足
        //2.保存订单
        String orderId= UUID.randomUUID().toString();
        System.out.println("订单生成成功："+orderId);
        //3.通过mq来完成消息的分发
        //参数1 交换机 参数2：路由key/queue队列名称 参数3：消息内容
        String exchangeName="topic_order_exchange";
        String rountKey="com.email.duanxin.test.";
        rabbitTemplate.convertAndSend(exchangeName,rountKey,orderId );
    }
}
