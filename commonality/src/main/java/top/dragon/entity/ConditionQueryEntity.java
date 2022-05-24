package top.dragon.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(value = "条件查询")
public class ConditionQueryEntity {
    @ApiModelProperty(value = "搜索的名字数组")
    private List<String> likeName;
    @ApiModelProperty(value = "搜索的值")
    private String likeValue;
    @ApiModelProperty(value = "排序的数组")
    private Map<String,String> sortMap;
    public ConditionQueryEntity setLikeName(String value,String ...names) {
        this.likeName = List.of(names);
        this.likeValue = value;
        return this;
    }
    public ConditionQueryEntity setSortMap(String name,String sort) {
        this.sortMap.put(name,sort);
        return this;
    }
}
