package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author sanriyue
 */
@Data
@ApiModel(value = "优惠券的实体类")
public class Coupons {
    @ApiModelProperty(value = "id")
    private Integer couponsId;
    @ApiModelProperty(value = "优惠金额")
    private Double couponsPrice;
    @ApiModelProperty(value = "起始时间")
    private Date beginTime;
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
}
