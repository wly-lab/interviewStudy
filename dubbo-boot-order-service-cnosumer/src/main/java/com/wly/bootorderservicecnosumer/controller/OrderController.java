package com.wly.bootorderservicecnosumer.controller;

import com.wly.gmall.bean.UserAddress;
import com.wly.gmall.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    IOrderService orderService;

    @ResponseBody
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid") String userId){
        System.out.println("用户id："+userId);
        List<UserAddress> userAddresses = orderService.initOrder(userId);
        return userAddresses;
    }

}
