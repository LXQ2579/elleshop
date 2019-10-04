package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.entity.Goods;
import com.mars.elleshop.entity.GoodsType;
import com.mars.elleshop.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sanriyue
 */
@Api
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ApiOperation(value = "根据ID查询到单个商品")
    @GetMapping("/findGoodsById.do")
    public JsonBean<Goods> findGoodsById(Integer goodsId){
        Goods goodsById = goodsService.findGoodsById(goodsId);

        return new JsonBean<Goods>(0,goodsById);
    }

    @ApiOperation(value = "根据品牌的ID查到到商品的简单信息")
    @GetMapping("/findGoodsByBrandId.do")
    public JsonBean<List<Goods>> findGoodsByBrandId(Integer brandId){
        List<Goods> goodsByBrandId = goodsService.findGoodsByBrandId(brandId);

        return new JsonBean<List<Goods>>(0,goodsByBrandId);
    }
}
