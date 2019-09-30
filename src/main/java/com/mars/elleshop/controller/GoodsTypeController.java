package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.entity.GoodsType;
import com.mars.elleshop.service.GoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sanriyue
 */
@Api
@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController {
    @Autowired
    GoodsTypeService goodsTypeService;

    @ApiOperation(value = "根据ID查询到单个商品的信息")
    @GetMapping("/findGoodsTypeById")
    public JsonBean<GoodsType> findGoodsTypeById(Integer goodsTypeId){
        if (goodsTypeId != null){
            GoodsType goodsType = goodsTypeService.findGoodsTypeById(goodsTypeId);
            return new JsonBean<GoodsType>(0,goodsType);

        }
        return null;
    }
}
