package com.mars.elleshop.service;

import com.mars.elleshop.entity.OrderItem;

import java.util.List;

public interface OrderService {
    List<OrderItem> queryById(Integer uid);

    int checkout(Integer uid,Integer aid);
}
