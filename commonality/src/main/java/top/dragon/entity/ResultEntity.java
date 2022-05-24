package top.dragon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统一返回类
 */
@Data
@ApiModel(value = "统一返回类")
public class ResultEntity {
    @ApiModelProperty(value = "代码")
    private Integer code = 0;
    @ApiModelProperty(value = "消息")
    private String msg = "";
    @ApiModelProperty(value = "数据")
    private Object data = null;
    public ResultEntity(){}
    public ResultEntity(Integer code){
        this.code = code;
    }
    public ResultEntity(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResultEntity(Integer code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    /**
     * 通知信息
     * @return 统一返回类
     */
    public static ResultEntity succeed(){
        return new ResultEntity(200,"succeed");
    }
    /**
     * 通知信息
     * @param msg 信息内容
     * @return 统一返回类
     */
    public static ResultEntity succeed(String msg){
        return new ResultEntity(200,msg);
    }

    /**
     * 通知信息
     * @param msg 信息内容
     * @param data 附件信息
     * @return 统一返回类
     */
    public static ResultEntity succeed(String msg,Object data){
        return new ResultEntity(200,msg,data);
    }
    /**
     * 通知信息
     * @param data 附件信息
     * @return 统一返回类
     */
    public static ResultEntity succeed(Object data){
        return new ResultEntity(200,"succeed",data);
    }
    /**
     * 错误信息
     * @return 统一返回类
     */
    public static ResultEntity error(){
        return new ResultEntity(500,"error");
    }

    /**
     * 错误信息
     * @param msg 信息内容
     * @return 统一返回类
     */
    public static ResultEntity error(String msg){
        return new ResultEntity(500,msg);
    }
    /**
     * 是否有效
     * @param flag 有效判断值
     * @return 统一返回类
     */
    public static ResultEntity isValid(Boolean flag){
        return flag ? succeed():error();
    }

    /**
     * 是否有效
     * @param flag 有效判断值
     * @param cMsg 有效信息
     * @param eMsg 无效信息
     * @return 统一返回类
     */
    public static ResultEntity isValid(Boolean flag,String cMsg,String eMsg){
        return flag ? succeed(cMsg):error(eMsg);
    }
    /**
     * 是否有效
     * @param flag 有效判断值
     * @param cMsg 有效信息
     * @param eMsg 无效信息
     * @param data 数据
     * @return 统一返回类
     */
    public static ResultEntity isValid(Boolean flag,String cMsg,String eMsg,Object data){
        return flag ? succeed(cMsg,data):error(eMsg);
    }


}
