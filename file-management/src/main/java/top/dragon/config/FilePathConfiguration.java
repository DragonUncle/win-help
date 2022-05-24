package top.dragon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.dragon.entity.ConfigParamEntity;
import top.dragon.entity.FileConfig;

import top.dragon.entity.SweetConfig;
import top.dragon.service.SystemConfig;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Configuration
public class FilePathConfiguration extends WebMvcConfigurationSupport {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfiguration.class);
    @Resource
    private SystemConfig systemConfig;

    private FileConfig initialFileConfiguration(){
        List<SweetConfig> systemConfigConfig = systemConfig.getConfig(
                ConfigParamEntity.listInfo("FileConfig",
                        Arrays.asList("path","url")));
        logger.info("文件路径配置信息:{}",systemConfigConfig);
        return FileConfig.getFileConfig(systemConfigConfig);
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        FileConfig fileConfig = initialFileConfiguration();
        logger.info("文件存放路径:{}",fileConfig.getPath());
        registry.addResourceHandler("/file/**").addResourceLocations("file://"+fileConfig.getPath());
        super.addResourceHandlers(registry);
    }
}
