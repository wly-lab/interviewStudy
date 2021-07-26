package com.wly.gmall.service.impl;

import com.wly.gmall.bean.UserAddress;
import com.wly.gmall.service.IUserService;

import java.util.Arrays;
import java.util.List;

public class UseServiceImpl implements IUserService {
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1=new UserAddress(1,"北京市昌平区","1","李老师","010-56253825","Y");
        UserAddress address2=new UserAddress(2,"北京市海淀区","1","王老师","010-56256551","Y");
        return Arrays.asList(address1,address2);
    }
}
