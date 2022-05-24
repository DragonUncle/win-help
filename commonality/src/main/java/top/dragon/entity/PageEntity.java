package top.dragon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="分页查询实体类")
public class PageEntity {
    @ApiModelProperty(value = "页码")
    private Integer page;
    @ApiModelProperty(value = "大小个数")
    private Integer limit;
}

