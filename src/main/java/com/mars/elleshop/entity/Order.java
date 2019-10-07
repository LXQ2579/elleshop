package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


/**
 * @author liujiulong
 * @date 2019/09/29  19:10:00
 */
@ApiModel("订单信息API")
@Getter
@Setter
public class Order {
    @ApiModelProperty("订单的id")
    private Integer orderId;
    @ApiModelProperty("生成订单的用户id")
    private Integer uid;
    @ApiModelProperty("生成订单的用户")
    private User user;
    @ApiModelProperty("订单的商品id")
    private Integer goodsTypeId;
    @ApiModelProperty("订单的商品")
    private GoodsType goodsType;
    @ApiModelProperty("订单的商品数量id")
    private Integer goodsNum;
    @ApiModelProperty("订单的支付方式id")
    private Integer paymentTypeId;
    @ApiModelProperty("订单的支付方式")
    private PaymentType paymentType;
    @ApiModelProperty("订单的创建时间")
    private Date createTime;
    @ApiModelProperty("订单的用户身份信息")
    private String idInformation;
    @ApiModelProperty("订单的状态, 0表示待付款, 1表示待发货, 2表示待收货, 3表示待评价, 10表示退货/退款")
    private Integer state;
    @ApiModelProperty("订单的总价")
    private Double price;
    @ApiModelProperty("订单的地址")
    private String address;


}
