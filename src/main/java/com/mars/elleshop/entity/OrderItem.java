package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("订单结算总项")
@Data
public class OrderItem {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("订单总价")
    private Double totalPrice;
    @ApiModelProperty("地址")
    private Address address;
    @ApiModelProperty("订单中的所有商品")
    private List<GoodsType> goodsType;
}
