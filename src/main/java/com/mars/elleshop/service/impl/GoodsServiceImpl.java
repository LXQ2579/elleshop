package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.GoodsDao;
import com.mars.elleshop.entity.Goods;
import com.mars.elleshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sanriyue
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    @Override
    public Goods findGoodsById(Integer goodsId) {
        Goods goodsById = goodsDao.findGoodsById(goodsId);
        if (goodsById == null) {
            throw new RuntimeException("商品找不到了，请联系管理员");
        }
        return goodsById;
    }
}
