package top.dragon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
@ApiModel(value = "用户请求实体类")
public class UserQueryEntity {
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "验证码")
    private String code;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
    @ApiModelProperty(value = "身份证号")
    private String idCard;
    @ApiModelProperty(value = "旧密码")
    private String oldPassword;
    @ApiModelProperty(value = "新密码")
    private String newPassword;
    @ApiModelProperty(value = "新手机号")
    private String newPhone;



}
