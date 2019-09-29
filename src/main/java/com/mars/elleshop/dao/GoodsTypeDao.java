package com.mars.elleshop.dao;

import com.mars.elleshop.entity.GoodsType;

import java.util.List;

/**
 * @author sanriyue
 */
public interface GoodsTypeDao {
    GoodsType findGoodTypeById(Integer goodsTypeId);

    List<GoodsType> findAllGoodsTypeByGoodsId(Integer goodsId);
}
