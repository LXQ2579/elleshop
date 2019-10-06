package com.mars.elleshop.dao;

import com.mars.elleshop.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDao {
    List<OrderItem> queryById(Integer uid);
    int doInsert(Map<String,Object> param);
    int doInsertDetail(List<Map<String,Object>>params);


}
