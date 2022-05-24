package top.dragon.entity;

import lombok.Data;
import top.dragon.utils.ObjectUtils;

import java.util.HashMap;
import java.util.List;

@Data
public class FileConfig {
    private String path;
    private String url;
    public static FileConfig getFileConfig(List<SweetConfig> value)   {
        HashMap<String, String> result = new HashMap<>();
        FileConfig fileConfig = new FileConfig();
        try {
            value.forEach((i)-> result.put(i.getConfigType(),i.getConfigValue()));
            Class<? extends FileConfig> aClass = fileConfig.getClass();
            ObjectUtils.extracted(result,fileConfig,aClass);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return fileConfig;
    }
}
