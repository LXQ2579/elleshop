package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.ClassifyDao;
import com.mars.elleshop.dao.GoodsTypeDao;
import com.mars.elleshop.entity.Classify;
import com.mars.elleshop.entity.GoodsType;
import com.mars.elleshop.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
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
        if (goodsType == null){
            throw new RuntimeException("信息找不到，请联系管理员");
        }
        ArrayList<Classify> classifyList = new ArrayList<>();

        //由于这个类的表一起连表查询会很麻烦，所以分开查询
        classifyList.add(classifyDao.findClassifyById(goodsType.getColor().getClassifyIdColor()));
        classifyList.add(classifyDao.findClassifyById(goodsType.getSize().getClassifyIdSize()));
        goodsType.setClassifyList(classifyList);
        return goodsType;
    }

    @Override
    public GoodsType findGoodsTypeByCZ(Integer colorId, Integer sizeId) {
        GoodsType byCZ = goodsTypeDao.findGoodsTypeByCZ(colorId, sizeId);
        if (byCZ ==null){
            throw new RuntimeException("商品找不到，请联系管理员");
        }
        return byCZ;
    }


}
