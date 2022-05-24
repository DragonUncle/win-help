package top.dragon.entity;

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
 * 工人评论喜欢
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_worker_comment_like")
@ApiModel(value="SweetWorkerCommentLike对象", description="工人评论喜欢")
public class SweetWorkerCommentLike implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工人评论喜欢评论Id")
    private Long commentLikeCid;

    @ApiModelProperty(value = "工人评论喜欢用户Id")
    private Long commentLikeUid;

    @ApiModelProperty(value = "工人评论喜欢创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime commentLikeCreateTime;

    @ApiModelProperty(value = "工人评论喜欢是否展示")
    private Boolean commentLikeIsShow;

    @ApiModelProperty(value = "工人评论喜欢是否删除")
    private Boolean commentLikeIsDel;


}
