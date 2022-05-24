package top.dragon.entity;

import lombok.Data;
import top.dragon.utils.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class RedisConfig {
    private String redisDatabase = "1";
    private String redisTimeOut = "5000";
    private String redisHost = "127.0.0.1";
    private String redisPassword = "";
    private String redisPort = "6379";
    public static  RedisConfig getConfig(List<SweetConfig> value)   {
        Map<String,String> result = new HashMap<String,String>();
        RedisConfig redisConfig = new RedisConfig();
        try {
            value.forEach((i)-> result.put(i.getConfigType(),i.getConfigValue()));
            Class<? extends RedisConfig> aClass = redisConfig.getClass();
            ObjectUtils.extracted(result,redisConfig,aClass);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return redisConfig;
    }
}
