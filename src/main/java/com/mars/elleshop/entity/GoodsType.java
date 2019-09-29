package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author sanriyue
 */
@ApiModel(value = "购买结算时的商品的实体类，一个颜色尺寸即有一个这个具体的类")
@Data
public class GoodsType {
    @ApiModelProperty(value = "订单商品类的ID")
    private Integer goodsTypeId;
    @ApiModelProperty(value = "所属商品的ID")
    private Integer goodsId;
    @ApiModelProperty(value = "所属的分类1，如尺寸，大小，尺码等")
    private Integer sizeId;
    @ApiModelProperty(value = "所属的分类2，如颜色，等等")
    private Integer colorId;
    @ApiModelProperty(value = "具体的价格")
    private Double price;
    @ApiModelProperty(value = "具体的图片")
    private String photoUrl;
}
