package top.dragon.configuration;


import com.alibaba.fastjson.JSON;
import lombok.Data;
import top.dragon.utils.DateUtils;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName: ResultException
 * @Description: 返回给前段的异常数据类
 * @Author: Dragon
 * @Date: 2019/9/17 15:37
 */
@Data
public class ResultException {
    private Integer code;
    private String message;
    private Object data;
    private String time;
    public ResultException(){}
    public ResultException(Integer code,String message,Object object,String time){
        this.code = code;
        this.message = message;
        this.data = object;
        this.time = time;
    }
    public ResultException(String message){
        this.code = 500;
        this.message = message;
        this.data = null;
        this.time = DateUtils.dfDateTime.format(LocalDateTime.now());
    }
    public ResultException(Integer code,String message){
        this.code = code;
        this.message = message;
        this.data = null;
        this.time = DateUtils.dfDateTime.format(LocalDateTime.now());
    }

    public ResultException(DragonException pe){
        this.code = pe.getCode();
        this.message = pe.getMessage();
        this.time = DateFormat.getDateTimeInstance().format(new Date());
    }
    public String toJson(){return JSON.toJSONString(this);}
}
