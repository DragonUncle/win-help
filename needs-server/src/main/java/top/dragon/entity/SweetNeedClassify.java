package top.dragon.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 服务分类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_need_classify")
@ApiModel(value="SweetNeedClassify对象", description="服务分类")
public class SweetNeedClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "服务分类Id")
    @TableId(value = "server_classify_id", type = IdType.AUTO)
    private Long serverClassifyId;

    @ApiModelProperty(value = "服务分类名字")
    private String serverClassifyName;

    @ApiModelProperty(value = "服务分类父Id")
    private Long serverClassifyPid;

    @ApiModelProperty(value = "服务分类是否显示")
    private Boolean serverClassifyIsShow;

    @ApiModelProperty(value = "服务分类是否删除")
    private Boolean serverClassifyIsDel;

    @ApiModelProperty(value = "服务分类创建时间")
    private LocalDateTime serverClassifyCreateTime;

    @ApiModelProperty(value = "服务分类备注")
    private String serverClassifyRemark;

    @ApiModelProperty(value = "服务分类建议价格")
    private BigDecimal serverClassifySuggestedPrice;


}
