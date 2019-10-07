package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author liujiulong
 * @date 2019/10/07  11:03:00
 */
@ApiModel(value ="支付方式实体类")
@Getter
@Setter
public class PaymentType {

    @ApiModelProperty(value = "支付方式的ID")
    private Integer paymentTypeId;
    @ApiModelProperty(value = "支付方式的名字")
    private String paymentTypeName;

}
