package top.dragon.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.dragon.entity.ConfigParamEntity;
import top.dragon.entity.SweetConfig;

import java.util.List;

@FeignClient(name = "system-config")
public interface SystemConfig {

    @PostMapping("/config/getConfigList")
    SweetConfig getConfigOne(@RequestBody ConfigParamEntity configParamEntity);

    @PostMapping("/config/getConfigList")
    List<SweetConfig> getConfig(@RequestBody ConfigParamEntity configParamEntity);
}

