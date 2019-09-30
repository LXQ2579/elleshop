package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "三级分类")
@Data
public class Kind {
    @ApiModelProperty("三级分类id")
    private Integer kindId;
    @ApiModelProperty("三级分类名")
    private String kindName;
    @ApiModelProperty("对应的二级分类id")
    private Integer classId;

}
