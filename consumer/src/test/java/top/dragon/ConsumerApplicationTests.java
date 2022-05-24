package top.dragon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.dragon.mapper.SweetUserMapper;
import top.dragon.feign.AliSmsService;
import top.dragon.utils.EncodeUtils;
import top.dragon.utils.JwtUtils;

import javax.annotation.Resource;


@SpringBootTest
class ConsumerApplicationTests {


    @Resource
    private SweetUserMapper userMapper;

    @Resource
    private AliSmsService smsService;

    @Resource
    private JwtUtils jwtUtils;

    @Test
    void contextLoads() {

        String str = "abc";
        System.out.println("原始：" + str);
        System.out.println("SHA后：" + EncodeUtils.shaEncode(str));

        //System.out.println(smsService.sendSms("15012345678", "123456"));

        System.out.println(jwtUtils.parseJWTToken("eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NTI3ODg3OTMsInVzZXJJZCI6MTUyMjU5ODgxNDc1Njc1MzQxMCwiaWF0IjoxNjUyNTI5NTkzLCJqdGkiOiI5ZWQ3ZjI4MS0wZGMyLTRhODgtOTllZC1jNmUwOTE0MDVkOTIifQ.pn12fiNHCoEF0OfV_O6kNuWGxx2VADAPZuxeh9mIxnw"));

    }

}

