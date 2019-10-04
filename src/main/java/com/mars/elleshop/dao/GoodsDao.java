package com.mars.elleshop.dao;

import com.mars.elleshop.entity.Goods;

/**
 * @author sanriyue
 */
public interface GoodsDao {
    Goods findGoodsById(Integer goodsId);
}
