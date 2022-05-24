package top.dragon.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商户
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_goods_shop")
@ApiModel(value="SweetGoodsShop对象", description="商户")
public class SweetGoodsShop implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "店铺id")
    @TableId(value = "shop_id", type = IdType.NONE)
    private Long shopId;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "店铺用户id")
    private Long shopUid;

    @ApiModelProperty(value = "店铺分类")
    private Long shopCategory;

    @ApiModelProperty(value = "店铺法人")
    private String shopBoss;

    @ApiModelProperty(value = "店铺简介介绍")
    private String shopIntroduce;

    @ApiModelProperty(value = "店铺地区")
    private String shopArea;

    @ApiModelProperty(value = "店铺地址")
    private String shopAddress;

    @ApiModelProperty(value = "店铺经纬度")
    private String shopLongitudeLatitude;

    @ApiModelProperty(value = "店铺官网")
    private String shopOfficial;

    @ApiModelProperty(value = "店铺评价")
    private String shopEvaluate;

    @ApiModelProperty(value = "店铺营业时间")
    private String shopBusinessHours;

    @ApiModelProperty(value = "店铺营业执照")
    private String shopLicense;

    @ApiModelProperty(value = "店铺法人正面")
    private String shopCorpnIdentityCardFront;

    @ApiModelProperty(value = "店铺法人背面")
    private String shopCorpnIdentityCardBack;

    @ApiModelProperty(value = "店铺属性")
    private String shopAtth;

    @ApiModelProperty(value = "店铺联系电话")
    private String shopTelephone;

    @ApiModelProperty(value = "店铺创建时间")
    private LocalDateTime shopCreateTime;

    @ApiModelProperty(value = "店铺审核时间")
    private LocalDateTime shopAuditTime;

    @ApiModelProperty(value = "店铺银行卡号")
    private String shopBankCardId;

    @ApiModelProperty(value = "店铺银行卡开户地址")
    private String shopBankCardOpenAddress;

    @ApiModelProperty(value = "店铺银行名字")
    private String shopBankCardName;

    @ApiModelProperty(value = "店铺银行卡归属人")
    private String shopBankCardBelonger;

    @ApiModelProperty(value = "店铺支付宝账号")
    private String shopAlipayId;

    @ApiModelProperty(value = "店铺支付宝名字")
    private String shopAlipayName;

    @ApiModelProperty(value = "店铺状态")
    private Integer shopStatus;

    @ApiModelProperty(value = "店铺是否显示")
    private Boolean shopIsShow;

    @ApiModelProperty(value = "店铺是否删除")
    private Boolean shopIsDel;

    @ApiModelProperty(value = "店铺图片")
    @TableField(exist = false)
    private List<String> shopImage;

}
