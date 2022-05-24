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
@ApiModel(value="获取配置参数实体类")
public class ConfigParamEntity {
    @ApiModelProperty(value = "配置分组")
    private String configGroup;
    @ApiModelProperty(value = "配置类型数组")
    private List<String> configType;;
    public static ConfigParamEntity listInfo(String group, String ...type) {
        return new ConfigParamEntity(group, Arrays.asList(type));
    }
    public static ConfigParamEntity listInfo(String group, List<String> type) {
        return new ConfigParamEntity(group, type);
    }
    public static ConfigParamEntity oneInfo(String group, String type) {
        return new ConfigParamEntity(group, Arrays.asList(type));
    }
}
