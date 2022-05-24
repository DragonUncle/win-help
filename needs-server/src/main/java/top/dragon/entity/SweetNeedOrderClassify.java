package top.dragon.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * 需求订单订单分类中间表
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_need_order_classify")
@ApiModel(value="SweetNeedOrderClassify对象", description="需求订单订单分类中间表")
public class SweetNeedOrderClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需求订单订单Id")
    private Long needOrderClassifyOid;

    @ApiModelProperty(value = "需求订单分类Id")
    private Long needOrderClassifyCid;

    @ApiModelProperty(value = "需求订单分类个数")
    private Integer needOrderClassifyNumber;

    @ApiModelProperty(value = "分类名称")
    @TableField(exist = false)
    private String needOrderClassifyName;


}
