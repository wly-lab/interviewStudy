package com.wly.gmall.service;

import com.wly.gmall.bean.UserAddress;

import java.util.List;

public interface IOrderService {
    public List<UserAddress> initOrder(String userId);
}
