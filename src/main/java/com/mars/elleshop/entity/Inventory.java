package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sanriyue
 */
@ApiModel(value = "购买结算时的商品的实体类，一个颜色尺寸即有一个这个具体的类")
@Data
public class Inventory implements Serializable {
    @ApiModelProperty("id")
    private Integer inventoryId;
    @ApiModelProperty("结算的商品id")
    private Integer goodsTypeId;
    @ApiModelProperty("商品id")
    private Integer goodsId;
    @ApiModelProperty("库存量")
    private Integer inventoryNum;
}
