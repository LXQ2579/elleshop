package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author leizhonggang
 */

@ApiModel(value = "三级分类")
@Data
public class Kind implements Serializable {
    @ApiModelProperty("三级分类id")
    private Integer kindId;
    @ApiModelProperty("三级分类名")
    private String kindName;
    @ApiModelProperty("对应的二级分类id")
    private Integer classId;

}
