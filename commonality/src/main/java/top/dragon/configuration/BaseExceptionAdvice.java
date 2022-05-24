package top.dragon.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @ClassName: BaseExceptionAdvice
 * @Description: 统一捕获运行异常，指定格式返回到前段处理
 * @Author: Dragon
 * @Date: 2019/9/17 15:34
 */

@RestControllerAdvice
public class BaseExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(BaseExceptionAdvice.class);
    @ExceptionHandler(DragonException.class)
    public ResponseEntity<ResultException> handleException(DragonException pe){
        logger.debug("ExceptionHandler code:{} Message:{}",pe.getCode(),pe.getMessage());
        return ResponseEntity.status(500).body(new ResultException(pe));
    }
}
