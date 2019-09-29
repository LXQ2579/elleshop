package com.mars.elleshop.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liujiulong
 * @date 2019/09/29  19:10:00
 */
@ApiModel(value ="用户实体类, 包含各种用户信息")
@Getter
@Setter
public class User implements Serializable {

    @ApiModelProperty(value = "用户的ID")
    private Integer uid;
    @ApiModelProperty(value = "用户的手机号")
    private String phone;
    @ApiModelProperty(value = "用户的名称")
    private String username;
    @ApiModelProperty(value = "用户的密码")
    private String password;
    @ApiModelProperty(value = "用户的账户余额")
    private Double balance;
    @ApiModelProperty(value = "用户的会员等级, 0 表示普通用户, 1 表示vip, 2 表示Svip")
    private Integer level;
    @ApiModelProperty(value = "用户的会员成长值")
    private Integer growRate;

}
