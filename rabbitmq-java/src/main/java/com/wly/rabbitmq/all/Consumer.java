package com.wly.rabbitmq.all;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
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
            //2.创建连接connection
            connection = connectionFactory.newConnection("生产者");
            //3.通过连接获取通道channel
            channel = connection.createChannel();
            //4.通过连接创建交换机  声明队列 丙丁关系 路由key 发送消息和接收消息
            String queueName="queue1";
            /**
             * param1 队列的名称
             * param2 是否要持久化  false非持久化
             * param3 排他性  是否独占
             * param4 是否自动删除  随着最后一个消费者消费完毕消息以后是否把队列自动删除
             * param5 携带附属参数
             *
             */
            //6.接收消息
            channel.basicConsume(queueName, true, new DeliverCallback() {
                @Override
                public void handle(String s, Delivery message) throws IOException {
                    System.out.println("收到消息是：" + new String(message.getBody(), "UTF-8"));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {
                    System.out.println("接收失败了！");
                }
            });
            System.out.println("开始接收消息！");
            System.in.read();
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
