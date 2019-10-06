package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("地址信息")
@Data
public class Address {
    @ApiModelProperty("地址id")
    private Integer aid;
    @ApiModelProperty("地址名称")
    private String name;
    @ApiModelProperty("联系电话")
    private String tel;
    @ApiModelProperty("详细地址")
    private String addr;
    @ApiModelProperty("默认地址")
    private Integer isDefault;
    @ApiModelProperty("状态")
    private Integer status;
}
