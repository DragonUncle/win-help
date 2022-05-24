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
 * 用户关注
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_user_attention")
@ApiModel(value="SweetUserAttention对象", description="用户关注")
public class SweetUserAttention implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关注的用户")
    @TableId(value = "user_attention_uid", type = IdType.NONE)
    private Long userAttentionUid;

    @ApiModelProperty(value = "被关注的用户")
    private Long userAttentionAid;

    @ApiModelProperty(value = "关注时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime userAttentionCreateTime;

    @ApiModelProperty(value = "关注取消时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime userAttentionCancelTime;


}
