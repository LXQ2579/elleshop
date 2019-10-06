package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.GoodsTypeDao;
import com.mars.elleshop.dao.OrderDao;
import com.mars.elleshop.entity.OrderItem;
import com.mars.elleshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private GoodsTypeDao goodsTypeDao;


    @Transactional
    @Override
    public List<OrderItem> queryById(Integer uid) {
        return orderDao.queryById(uid);
    }

    @Override
    public int checkout(Integer uid, Integer aid) {
        int result = 0;
        //往订单表添加数据
        Map<String,Object> param = new HashMap<>();
        param.put("uid",uid);
        param.put("aid",aid);
        result += orderDao.doInsert(param);
        //往订单明细表中添加数据

        return 0;
    }
}
