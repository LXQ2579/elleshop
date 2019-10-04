package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:leizhonggang
 * @Date:2019-09-30
 */

@ApiModel(value = "一级分类")
@Data
public class Category implements Serializable {

    @ApiModelProperty(value = "一级分类id")
    private Integer categoryId;
    @ApiModelProperty(value = "一级分类名")
    private String categoryName;
    @ApiModelProperty(value = "私有的二级分类属性的集合")
    private List<Class> classList;

}
