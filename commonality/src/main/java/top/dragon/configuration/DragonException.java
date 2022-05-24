package top.dragon.configuration;

import lombok.Getter;

/**
 * @ClassName: PokerException
 * @Description:
 * @Author: Dragon
 * @Date: 2019/9/17 15:29
 */
@Getter
public class DragonException extends RuntimeException {
    private Integer code = 500;
    public DragonException(String message){
        super(message);
    }
    public DragonException(String message, Throwable cause){
        super(message,cause);
    }
    public DragonException(Integer code, String message){
        super(message);
        this.code = code;
    }
    public DragonException(Integer code, String message, Throwable cause){
        super(message,cause);
        this.code = code;
    }
}
