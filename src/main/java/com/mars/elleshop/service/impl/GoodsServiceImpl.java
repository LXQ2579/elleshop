package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.GoodsDao;
import com.mars.elleshop.entity.Goods;
import com.mars.elleshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Goods> findGoodsByBrandId(Integer brandId) {
        List<Goods> goodsList = goodsDao.findGoodsByBrandId(brandId);
        if (goodsList ==null){
            throw new RuntimeException("商品找不到了，请联系管理员");
        }
        return goodsList;
    }

    @Override
    public List<Goods> findAllGoods() {
        List<Goods> allGoods = goodsDao.findAllGoods();
        if (allGoods ==null){
            throw new RuntimeException("商品找不到了，请联系管理员");

        }
        return allGoods;
    }

    @Override
    public List<Goods> findGoodsByStyleId(Integer styleId) {
        List<Goods> allGoods = goodsDao.findGoodsByStyleId(styleId);
        if (allGoods ==null){
            throw new RuntimeException("商品找不到了，请联系管理员");

        }
        return allGoods;
    }

    @Override
    public List<Goods> findGoodsByAreaId(Integer areaId) {
        List<Goods> allGoods = goodsDao.findGoodsByAreaId(areaId);
        if (allGoods ==null){
            throw new RuntimeException("商品找不到了，请联系管理员");

        }
        return allGoods;
    }
}
