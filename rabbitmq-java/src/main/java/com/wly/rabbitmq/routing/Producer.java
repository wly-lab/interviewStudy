package com.wly.rabbitmq.routing;

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
            String queueName="queue1";
            /**
             * param1 队列的名称
             * param2 是否要持久化  false非持久化 非持久化队列消息会存盘吗？会 但是会随着服务器重启丢失
             * param3 排他性  是否独占
             * param4 是否自动删除  随着最后一个消费者消费完毕消息以后是否把队列自动删除
             * param5 携带附属参数
             *
             */
            channel.queueDeclare(queueName,false,false,false,null);
            //5.准备消息内容
            String message="hello fanout!";
            //6.准备交换机
            String exchangeName="fanout-exchange";
            //7.定义路由key
            String roteKey="";
            //8.指定交换机类型
            String type="fanout";
            //6.发送消息给队列queue
            channel.basicPublish(exchangeName,queueName,null,message.getBytes());
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
