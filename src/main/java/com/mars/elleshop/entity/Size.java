package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author sanriyue
 */
@ApiModel(value = "商品细分类的凭证属性2，用于存储尺码，大小号等类型的信息")
@Data
public class Size {
    private Integer sizeId;
    @ApiModelProperty(value = "具体的内容，如XM 均码  42等")
    private String sizeName;
    private Integer ofTypeId;
}
