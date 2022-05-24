package top.dragon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 配置
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_config")
@ApiModel(value="SweetConfig对象", description="配置")
public class SweetConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "配置的id")
    @TableId(value = "config_id", type = IdType.AUTO)
    private Integer configId;

    @ApiModelProperty(value = "配置名称")
    private String configName;

    @ApiModelProperty(value = "配置类型")
    private String configType;

    @ApiModelProperty(value = "配置分组")
    private String configGroup;

    @ApiModelProperty(value = "配置数值")
    private String configValue;

    @ApiModelProperty(value = "配置内容")
    private String configDetails;

    @ApiModelProperty(value = "配置备注")
    private String configRemarks;


}
