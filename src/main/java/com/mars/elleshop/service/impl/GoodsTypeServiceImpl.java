package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.ClassifyDao;
import com.mars.elleshop.dao.GoodsTypeDao;
import com.mars.elleshop.entity.Classify;
import com.mars.elleshop.entity.GoodsType;
import com.mars.elleshop.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author sanriyue
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeDao goodsTypeDao;
    @Autowired
    private ClassifyDao classifyDao;

    @Override
    public GoodsType findGoodsTypeById(Integer goodsTypeId) {
        GoodsType goodsType = goodsTypeDao.findGoodsTypeById(goodsTypeId);
        ArrayList<Classify> classifyList = new ArrayList<>();
        //由于这个类的表一起连表查询会很麻烦，所以分开查询
        classifyList.add(classifyDao.findClassifyById(goodsType.getColorId()));
        classifyList.add(classifyDao.findClassifyById(goodsType.getSizeId()));
        goodsType.setClassifyList(classifyList);
        return goodsType;
    }
}
