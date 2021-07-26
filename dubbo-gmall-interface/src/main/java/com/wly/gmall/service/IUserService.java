package com.wly.gmall.service;

import com.wly.gmall.bean.UserAddress;

import java.util.List;

public interface IUserService {
    /**
     *
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);
}
