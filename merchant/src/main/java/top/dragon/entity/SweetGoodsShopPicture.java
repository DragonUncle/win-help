package top.dragon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_goods_shop_picture")
@ApiModel(value="SweetGoodsShopPicture对象", description="")
public class SweetGoodsShopPicture implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商户图片Id")
    @TableId(value = "shop_picture_id", type = IdType.NONE)
    private Long shopPictureId;

    @ApiModelProperty(value = "商户图片商户Id")
    private Long shopPictureSid;

    @ApiModelProperty(value = "商品图片链接")
    private String shopPictureUrl;

    @ApiModelProperty(value = "商户图片排序")
    private Integer shopPictureSort;

    @ApiModelProperty(value = "商户图片是否显示")
    private Boolean shopPictureIsShow;

    @ApiModelProperty(value = "商户图片是否删除")
    private Boolean shopPictureIsDel;

    @ApiModelProperty(value = "商户图片创建时间")
    private LocalDateTime shopPictureCreateTime;


}
