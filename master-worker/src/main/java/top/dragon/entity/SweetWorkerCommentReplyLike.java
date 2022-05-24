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
 * 工人评论回复喜欢
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_worker_comment_reply_like")
@ApiModel(value="SweetWorkerCommentReplyLike对象", description="工人评论回复喜欢")
public class SweetWorkerCommentReplyLike implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工人评论回答喜欢的回答Id")
    private Long replyLikeRid;

    @ApiModelProperty(value = "工人评论回答喜欢的用户Id")
    private Long replyLikeUid;

    @ApiModelProperty(value = "工人评论回答喜欢的创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime replyLikeCreateTime;

    @ApiModelProperty(value = "工人评论回答喜欢的回答Id")
    private Boolean replyLikeIsShow;

    @ApiModelProperty(value = "工人评论回答喜欢的回答Id")
    private Boolean replyLikeIsDel;


}
