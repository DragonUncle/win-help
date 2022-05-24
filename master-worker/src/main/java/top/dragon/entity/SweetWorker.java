package top.dragon.entity;

import java.math.BigDecimal;
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
 * 工人列表
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_worker")
@ApiModel(value="SweetWorker对象", description="工人列表")
public class SweetWorker implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工人Id")
    @TableId(value = "worker_id", type = IdType.AUTO)
    private Long workerId;

    @ApiModelProperty(value = "工人用户Id")
    private Long workerUid;

    @ApiModelProperty(value = "工人名字")
    private String workerName;

    @ApiModelProperty(value = "工人头像")
    private String workerAvatar;

    @ApiModelProperty(value = "工人手机号")
    private String workerPhone;

    @ApiModelProperty(value = "工人密码")
    private String workerPassword;

    @ApiModelProperty(value = "工人订单数量")
    private Integer workerOrderCount;

    @ApiModelProperty(value = "工人所在区域")
    private String workerArea;

    @ApiModelProperty(value = "工人地址")
    private String workerAddress;

    @ApiModelProperty(value = "工人真实姓名")
    private String workerRealName;

    @ApiModelProperty(value = "工人手持身份证")
    private String workerHandCard;

    @ApiModelProperty(value = "工人身份证正面")
    private String workerCardFront;

    @ApiModelProperty(value = "工人身份证背面")
    private String workerCardBack;

    @ApiModelProperty(value = "工人缴纳保证金")
    private BigDecimal workerPayDeposit;

    @ApiModelProperty(value = "工人完结订单")
    private Integer workerFinishOrderCount;

    @ApiModelProperty(value = "工人取消订单")
    private Integer workerCancelOrderCount;

    @ApiModelProperty(value = "工人评价")
    private Integer workerEvaluate;

    @ApiModelProperty(value = "工人工作单位")
    private String workerWorkUnit;

    @ApiModelProperty(value = "工人工作地址")
    private String workerWorkAddress;

    @ApiModelProperty(value = "工人工作单位电话")
    private String workerWorkTelephone;

    @ApiModelProperty(value = "工人钱包")
    private BigDecimal workerWallet;

    @ApiModelProperty(value = "工人承诺内容")
    private String workerPromise;

    @ApiModelProperty(value = "工人是否上线")
    private Boolean workerIsShow;

    @ApiModelProperty(value = "工人状态")
    private Integer workerStatus;

    @ApiModelProperty(value = "工人是否注销")
    private Boolean workerIsDel;


}
