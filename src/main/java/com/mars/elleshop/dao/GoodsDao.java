package com.mars.elleshop.dao;

import com.mars.elleshop.entity.Goods;

import java.util.List;

/**
 * @author sanriyue
 */
public interface GoodsDao {
    Goods findGoodsById(Integer goodsId);

    List<Goods> findGoodsByBrandId (Integer brandId);

    List<Goods> findAllGoods();

    List<Goods> findGoodsByStyleId(Integer styleId);

    List<Goods> findGoodsByAreaId(Integer areaId);
}
