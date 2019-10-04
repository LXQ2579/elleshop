package com.mars.elleshop.service;

import com.mars.elleshop.entity.Goods;

/**
 * @author sanriyue
 */
public interface GoodsService {
    Goods findGoodsById(Integer goodsId);
}
