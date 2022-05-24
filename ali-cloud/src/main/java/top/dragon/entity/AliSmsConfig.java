package top.dragon.entity;

import lombok.Data;
import top.dragon.utils.ObjectUtils;

import java.util.HashMap;
import java.util.List;

@Data
public class AliSmsConfig {
    private String regionId;        //地区
    private String accessKeyId;
    private String secret;
    private String domain;
    private String templateName;
    private String template;
    private String timeOut;
    public static  AliSmsConfig getAliSmsConfig(List<SweetConfig> value)   {
        HashMap<String, String> result = new HashMap<>();
        AliSmsConfig aliSmsConfig = new AliSmsConfig();
        try {
            value.forEach((i)-> result.put(i.getConfigType(),i.getConfigValue()));
            Class<? extends AliSmsConfig> aClass = aliSmsConfig.getClass();
            ObjectUtils.extracted(result,aliSmsConfig,aClass);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return aliSmsConfig;
    }
}
