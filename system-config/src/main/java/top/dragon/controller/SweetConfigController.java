package top.dragon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.jsonwebtoken.lang.Collections;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import top.dragon.entity.ConfigChangeEntity;
import top.dragon.entity.ConfigParamEntity;
import top.dragon.entity.SweetConfig;
import top.dragon.service.SweetConfigService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 配置 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-17
 */
@RestController
@RequestMapping("/config")
@Api(tags = "配置接口")
public class SweetConfigController {
    @Resource
    private SweetConfigService configService;

    @PostMapping("/getConfigList")
    @ApiOperation(value = "获取配置列表")
    public List<SweetConfig> getConfig(@RequestBody ConfigParamEntity configParamEntity) {
        return configService.list(new QueryWrapper<SweetConfig>()
                .eq("config_group", configParamEntity.getConfigGroup())
                .in("config_type", configParamEntity.getConfigType()));
    }
    @PostMapping("/getConfig")
    @ApiOperation(value = "获取配置")
    public SweetConfig getConfigOne(@RequestBody ConfigParamEntity configParamEntity) {

        if (Collections.isEmpty(configParamEntity.getConfigType())) return new SweetConfig();
        return configService.getOne(new QueryWrapper<SweetConfig>()
                .eq("config_group", configParamEntity.getConfigGroup())
                .eq("config_type", configParamEntity.getConfigType().get(0)));
    }
    @PostMapping("/changeConfig")
    @ApiOperation(value = "修改配置")
    public Boolean changeConfig(@RequestBody ConfigChangeEntity configChangeEntity) {
        SweetConfig config = configService.getOne(new QueryWrapper<SweetConfig>()
                .eq("config_group", configChangeEntity.getConfigGroup())
                .eq("config_type", configChangeEntity.getConfigType()));
        config.setConfigValue(configChangeEntity.getConfigValue());
        return configService.updateById(config);
    }

}

