package top.dragon.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_user")
@ApiModel(value="SweetUser对象", description="用户")
public class SweetUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.NONE)
    private Long userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户手机号")
    private String userPhone;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "用户邮箱")
    private String userEmail;

    @ApiModelProperty(value = "用户微信OpenId")
    private String userOpenId;

    @ApiModelProperty(value = "用户的支付宝账号")
    private String userAlipayId;

    @ApiModelProperty(value = "用户qq")
    private String userQq;

    @ApiModelProperty(value = "用户生日")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate userBirthday;

    @ApiModelProperty(value = "用户证件名称")
    private String userIdentityName;

    @ApiModelProperty(value = "用户证件号")
    private String userIdentityId;

    @ApiModelProperty(value = "用户创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime userCreateTime;

    @ApiModelProperty(value = "用户头像")
    private String userIcon;

    @ApiModelProperty(value = "用户钱包")
    private BigDecimal userBalance;

    @ApiModelProperty(value = "用户地区")
    private String userArea;

    @ApiModelProperty(value = "用户地址")
    private String userAddress;

    @ApiModelProperty(value = "用户性别")
    private String userSex;

    @ApiModelProperty(value = "用户个性签名")
    private String userSignature;

    @ApiModelProperty(value = "用户邀请码")
    private String userInviteCode;

    @ApiModelProperty(value = "用户被邀请码")
    private String userInviteeCode;

    @ApiModelProperty(value = "用户状态")
    private Integer userStatus;

    @ApiModelProperty(value = "用户是否删除")
    private Boolean userIsDel;

    @ApiModelProperty(value = "身份验证")
    @TableField(exist = false)
    private String userToken;

    @ApiModelProperty(value = "身份商家")
    @TableField(exist = false)
    private Boolean userIsShop;

    @ApiModelProperty(value = "身份工人")
    @TableField(exist = false)
    private Boolean userIsWorker;
}
