package com.wly.bootorderservicecnosumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wly.gmall.bean.UserAddress;
import com.wly.gmall.service.IOrderService;
import com.wly.gmall.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Reference
    IUserService userService;
    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId:"+userId);
        List<UserAddress> addresslist=userService.getUserAddressList(userId);
        return addresslist;
    }
}
