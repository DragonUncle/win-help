package top.dragon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="设置配置参数实体类")
public class ConfigChangeEntity {
    @ApiModelProperty(value = "配置分组")
    private String configGroup;
    @ApiModelProperty(value = "配置类型")
    private String configType;;
    @ApiModelProperty(value = "配置内容")
    private String configValue;;
    public static ConfigChangeEntity setValue(String group, String type,String value) {
        return new ConfigChangeEntity(group, type,value);
    }
    public static ConfigChangeEntity setEmpty(String group, String type) {
        return new ConfigChangeEntity(group, type,"");
    }
}
