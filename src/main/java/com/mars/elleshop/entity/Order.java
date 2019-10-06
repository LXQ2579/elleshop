package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@ApiModel("订单")
@Data
public class Order implements Serializable {
    @ApiModelProperty("订单id")
    private Integer id;
    @ApiModelProperty("订单地址id")
    private Integer aId;
    @ApiModelProperty("订单创建时间")
    private Timestamp createTime;
}
