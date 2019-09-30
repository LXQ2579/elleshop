package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

//二级分类
@ApiModel(value = "二级分类")
@Data
public class Class {
    @ApiModelProperty("二级分类id")
    private Integer classId;
    @ApiModelProperty("二级分类名")
    private String className;
    @ApiModelProperty("对应的一级分类id")
    private Integer categoryId;
    @ApiModelProperty("对应的三级分类的集合")
    private List<Kind> kindList;


}
