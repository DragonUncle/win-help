package top.dragon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.dragon.server.SystemConfig;

import javax.annotation.Resource;

@SpringBootTest
class AliCloudApplicationTests {
    @Resource
    private SystemConfig systemConfig;
    @Test
    void contextLoads() {
//        List<SweetConfig> systemConfigConfig = systemConfig.getConfig(
//                ConfigParamEntity.listInfo("AliSmsChinaCode",
//                        Arrays.asList("regionId", "accessKeyId", "secret", "domain",
//                                "templateName", "template", "timeOut")));
//        System.out.println(systemConfigConfig);
        System.out.println(System.currentTimeMillis());

    }

}
