package com.mars.elleshop.service;

import com.mars.elleshop.entity.GoodsType;

/**
 * @author sanriyue
 */
public interface GoodsTypeService {
    GoodsType findGoodsTypeById(Integer goodsTypeId);
    GoodsType findGoodsTypeByCZ(Integer colorId ,Integer sizeId);
}
