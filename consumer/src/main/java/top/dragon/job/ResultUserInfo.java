package top.dragon.job;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.dragon.entity.SweetUser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ApiModel(value="返回用户类", description="用户")
public class ResultUserInfo {

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户手机号")
    private String userPhone;

    @ApiModelProperty(value = "用户邮箱")
    private String userEmail;

    @ApiModelProperty(value = "用户qq")
    private String userQq;

    @ApiModelProperty(value = "用户生日")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate userBirthday;

    @ApiModelProperty(value = "用户证件名称")
    private String userIdentityName;

    @ApiModelProperty(value = "用户证件号")
    private String userIdentityId;

    @ApiModelProperty(value = "用户创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime userCreateTime;

    @ApiModelProperty(value = "用户头像")
    private String userAvatar;

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

    @ApiModelProperty(value = "用户状态")
    private Integer userStatus;

    @ApiModelProperty(value = "是否是商家")
    private Boolean userIsShop;

    @ApiModelProperty(value = "是否是工人")
    private Boolean userIsWorker;

    @ApiModelProperty(value = "用户令牌")
    private String userToken;

    public ResultUserInfo(SweetUser sweetUser) {
        this.userAddress = sweetUser.getUserAddress();
        this.userArea = sweetUser.getUserArea();
        this.userBalance = sweetUser.getUserBalance();
        this.userBirthday = sweetUser.getUserBirthday();
        this.userCreateTime = sweetUser.getUserCreateTime();
        this.userEmail = sweetUser.getUserEmail();
        this.userAvatar = sweetUser.getUserIcon();
        this.userId = sweetUser.getUserId();
        this.userIdentityId = sweetUser.getUserIdentityId();
        this.userIdentityName = sweetUser.getUserIdentityName();
        this.userInviteCode = sweetUser.getUserInviteCode();
        this.userName = sweetUser.getUserName();
        this.userPhone = sweetUser.getUserPhone();
        this.userQq = sweetUser.getUserQq();
        this.userSex = sweetUser.getUserSex();
        this.userSignature = sweetUser.getUserSignature();
        this.userStatus = sweetUser.getUserStatus();
        this.userIsShop = sweetUser.getUserIsShop();
        this.userToken = sweetUser.getUserToken();
    }
}
