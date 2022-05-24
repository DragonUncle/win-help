package top.dragon.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 工人评论
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_worker_comment")
@ApiModel(value="SweetWorkerComment对象", description="工人评论")
public class SweetWorkerComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工人评价id")
    @TableId(value = "worker_comment_id", type = IdType.NONE)
    private Long workerCommentId;

    @ApiModelProperty(value = "工人评价人")
    private Long workerCommentUid;

    @ApiModelProperty(value = "工人评价的工人")
    private Long workerCommentWid;

    @ApiModelProperty(value = "工人评价的评分")
    private Integer workerCommentEvaluate;

    @ApiModelProperty(value = "工人评价的内容")
    private String workerCommentDetails;

    @ApiModelProperty(value = "工人评价是否展示")
    private Boolean workerCommentIsShow;

    @ApiModelProperty(value = "工人评价是否删除")
    private Boolean workerCommentIsDel;

    @ApiModelProperty(value = "工人评价打赏金额(小费)")
    private BigDecimal workerCommentTipping;

    @ApiModelProperty(value = "工人评价时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime workerCommentCreateTime;


}
