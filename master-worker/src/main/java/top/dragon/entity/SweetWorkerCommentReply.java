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
 * 工人评论回复
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_worker_comment_reply")
@ApiModel(value="SweetWorkerCommentReply对象", description="工人评论回复")
public class SweetWorkerCommentReply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工人评论回复Id")
    @TableId(value = "comment_reply_id", type = IdType.NONE)
    private Long commentReplyId;

    @ApiModelProperty(value = "工人评论回复的评论")
    private Long commentReplyPid;

    @ApiModelProperty(value = "工人评论回复的评论Id")
    private Long commentReplyCid;

    @ApiModelProperty(value = "工人评论回复的用户Id")
    private Long commentReplyUid;

    @ApiModelProperty(value = "工人评论回复的内容")
    private String commentReplyDetails;

    @ApiModelProperty(value = "工人评论回复是否显示")
    private Boolean commentReplyIsShow;

    @ApiModelProperty(value = "工人评论回复是否删除")
    private Boolean commentReplyIsDel;

    @ApiModelProperty(value = "工人评论回复创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime commentReplyCreateTime;


}
