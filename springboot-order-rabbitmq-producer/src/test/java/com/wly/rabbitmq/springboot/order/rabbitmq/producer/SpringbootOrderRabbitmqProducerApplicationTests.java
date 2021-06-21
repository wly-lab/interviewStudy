package com.wly.rabbitmq.springboot.order.rabbitmq.producer;

import com.wly.rabbitmq.springboot.order.rabbitmq.producer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootOrderRabbitmqProducerApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("1","1",12);
    }


}
