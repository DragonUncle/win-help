package top.dragon.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 需求列表
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_need_order")
@ApiModel(value="SweetNeedOrder对象", description="需求列表")
public class SweetNeedOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需求Id")
    @TableId(value = "need_id", type = IdType.NONE)
    private Long needId;

    @ApiModelProperty(value = "需求名字")
    private String needName;

    @ApiModelProperty(value = "需求用户Id")
    private Long needUid;

    @ApiModelProperty(value = "需求工人Id")
    private Long needWid;

    @ApiModelProperty(value = "需求发布时间")
    private LocalDateTime needCreateTime;

    @ApiModelProperty(value = "需求定金")
    private BigDecimal needDeposit;

    @ApiModelProperty(value = "需求真实价格")
    private BigDecimal needRealPrice;

    @ApiModelProperty(value = "需求支付价格")
    private BigDecimal needPayPrice;

    @ApiModelProperty(value = "需求成交价格")
    private BigDecimal needTransactionPrice;

    @ApiModelProperty(value = "需求预约开始时间")
    private LocalDateTime needAppointStartTime;

    @ApiModelProperty(value = "需求预约结束时间")
    private LocalDateTime needAppointEndTime;

    @ApiModelProperty(value = "需求结算时间")
    private LocalDateTime needBalanceTime;

    @ApiModelProperty(value = "需求用户状态")
    private Integer needUserState;

    @ApiModelProperty(value = "需求工人状态")
    private Integer needWorkerState;

    @ApiModelProperty(value = "需求最终结果时间更新")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime needUltimatelyTime;

    @ApiModelProperty(value = "需求用户是否删除")
    private Boolean needUserIsDel;

    @ApiModelProperty(value = "需求工人是否删除")
    private Boolean needWorkerIsDel;

    @ApiModelProperty(value = "需求取消理由")
    private Integer needCancelType;

    @ApiModelProperty(value = "需求处理地点")
    private Integer needWorkplace;

}
