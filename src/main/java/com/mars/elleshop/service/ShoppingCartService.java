package com.mars.elleshop.service;

import com.mars.elleshop.entity.ShoppingCart;
import com.mars.elleshop.entity.User;

import java.util.List;

public interface ShoppingCartService {

    //添加商品到购物车
    void addGoodsToCart(User user, Integer goodsTypeId);

    //从购物车删除商品
    void delGoodsFromCart(User user,String[] goodsTypeId);

    //获取商品列表
    List<ShoppingCart> list(User user);



}
