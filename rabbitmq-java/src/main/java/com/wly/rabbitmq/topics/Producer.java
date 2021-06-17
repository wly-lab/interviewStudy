package com.wly.rabbitmq.topics;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) {
        //所有中间件技术都是基于tcp/ip协议基础上构建新型的协议规范，只不过rabbitmq遵循的是amqp
        //ip port

        //1.创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("47.94.130.75");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("wly");
        connectionFactory.setPassword("wly");
        connectionFactory.setVirtualHost("/");

        Connection connection=null;
        Channel channel=null;
        try{
            //2.创建连接connection rabbitmq为什么事基于channel去处理而不是基于连接？ 连接是短连接
             connection = connectionFactory.newConnection("生产者");
            //3.通过连接获取通道channel
             channel = connection.createChannel();
            //4.通过连接创建交换机  声明队列 丙丁关系 路由key 发送消息和接收消息

            //5.准备消息内容
            String message="hello direct!";
            //6.准备交换机
            String exchangeName="topic-exchange";
            //7.定义路由key
            String roteKey="com.order.test.xxx";
            //8.指定交换机类型
            String type="topic";
            //6.发送消息给队列queue
            channel.basicPublish(exchangeName,roteKey,null,message.getBytes());
            System.out.println("消息发送成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(channel!=null&&channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null&&connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //7.关闭连接
        //8.关闭通道
    }
}
