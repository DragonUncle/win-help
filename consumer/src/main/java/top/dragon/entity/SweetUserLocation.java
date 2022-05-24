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
 * 用户收货地址
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sweet_user_location")
@ApiModel(value="SweetUserLocation对象", description="用户收货地址")
public class SweetUserLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "位置Id")
    @TableId(value = "location_id", type = IdType.NONE)
    private Long locationId;

    @ApiModelProperty(value = "位置用户Id")
    private Long locationUid;

    @ApiModelProperty(value = "位置名称")
    private String locationName;

    @ApiModelProperty(value = "位置区域")
    private String locationArea;

    @ApiModelProperty(value = "位置地址")
    private String locationAddress;

    @ApiModelProperty(value = "位置联系方式")
    private String locationTelephone;

    @ApiModelProperty(value = "位置默认地址")
    private Boolean locationIsDefault;

    @ApiModelProperty(value = "位置标签")
    private String locationFlag;

    @ApiModelProperty(value = "位置内容")
    private String locationDetail;

    @ApiModelProperty(value = "位置备注信息")
    private String locationRemark;

    @ApiModelProperty(value = "位置创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime locationCreateTime;

    @ApiModelProperty(value = "位置是否删除")
    private Boolean locationIsDel;


}
