package com.mars.elleshop.dao;

import com.mars.elleshop.entity.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sanriyue
 */
@Repository
public interface GoodsTypeDao {
    GoodsType findGoodsTypeById(Integer goodsTypeId);

    List<GoodsType> findAllGoodsTypeByGoodsId(Integer goodsId);
}
