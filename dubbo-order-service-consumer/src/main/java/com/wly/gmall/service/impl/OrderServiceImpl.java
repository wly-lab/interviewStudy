package com.wly.gmall.service.impl;

import com.wly.gmall.bean.UserAddress;
import com.wly.gmall.service.IOrderService;
import com.wly.gmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IUserService userService;
    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId:"+userId);
        List<UserAddress> addresslist=userService.getUserAddressList(userId);
        for (UserAddress address:addresslist) {
            System.out.println(address.getUserAddress());
        }
        return addresslist;
    }
}
