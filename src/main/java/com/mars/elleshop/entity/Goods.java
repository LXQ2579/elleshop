package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author sanriyue
 */
@ApiModel(value = "商品的实体类，不是购买结算的主体，只是用于关联和储存各种的商品信息")
@Data
public class Goods {
    @ApiModelProperty(value = "商品的ID")
    private Integer goodsId;
    @ApiModelProperty(value = "商品的名字")
    private String goodsName;
    @ApiModelProperty(value = "商品所属品牌的id")
    private Integer brandId;
    @ApiModelProperty(value = "所属风格的id")
    private Integer styleId;
    @ApiModelProperty(value = "所属地区的ID")
    private Integer areaId;
    @ApiModelProperty(value = "商品视频的链接地址")
    private String videoUrl;
    @ApiModelProperty(value = "具体的描述信息")
    private String goodsMsg;
}
