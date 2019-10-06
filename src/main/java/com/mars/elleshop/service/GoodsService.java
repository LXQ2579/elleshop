package com.mars.elleshop.service;

import com.mars.elleshop.entity.Goods;

import java.util.List;

/**
 * @author sanriyue
 */
public interface GoodsService {
    Goods findGoodsById(Integer goodsId);

    List<Goods> findGoodsByBrandId (Integer brandId);
    List<Goods> findAllGoods ();
    List<Goods> findGoodsByStyleId(Integer styleId);

    List<Goods> findGoodsByAreaId(Integer areaId);
}
