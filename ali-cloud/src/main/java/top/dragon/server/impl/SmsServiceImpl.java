package top.dragon.server.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.dragon.configuration.BaseExceptionAdvice;
import top.dragon.entity.AliSmsConfig;
import top.dragon.entity.ConfigParamEntity;
import top.dragon.entity.SweetConfig;
import top.dragon.server.SmsService;
import top.dragon.server.SystemConfig;
import top.dragon.utils.RedisUtil;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class SmsServiceImpl implements SmsService {
    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
    private static final String phoneName = "phone-";

    @Resource
    private SystemConfig systemConfig;

    @Resource
    private RedisUtil redisUtil;

    private static final Random random = new Random();
    @Override
    public Boolean sendSms(String phone) {
        List<SweetConfig> systemConfigConfig = systemConfig.getConfig(
                ConfigParamEntity.listInfo("AliSmsChinaCode",
                        Arrays.asList("regionId", "accessKeyId", "secret", "domain",
                                "templateName", "template", "timeOut")));
        AliSmsConfig smsConfig = AliSmsConfig.getAliSmsConfig(systemConfigConfig);
        HashMap<String, String> param = new HashMap<>();
        StringBuilder code = new StringBuilder();//定义一个code
//        for (int i = 0; i < 6; i++) { code.append(random.nextInt(10)); }
        param.put("code", code.toString());
        code.append("876231");
        redisUtil.write(phoneName+phone, code.toString(),
                Long.parseLong(smsConfig.getTimeOut()) * 60, TimeUnit.SECONDS);
        logger.info("手机号：{},发送短信验证码：{}", phone ,code.toString());
        return true;
//        return send(phone, param, smsConfig);
    }

    @Override
    public Boolean send(String telephone, Map<String, String> value, AliSmsConfig smsConfig) {
        try {
            Config config = new Config()
                    // 您的AccessKey ID
                    .setAccessKeyId(smsConfig.getAccessKeyId())
                    // 您的AccessKey Secret
                    .setAccessKeySecret(smsConfig.getSecret())
                    // Domain网址
                    .setEndpoint(smsConfig.getDomain());
            Client client= new Client(config);
            SendSmsRequest sendSmsRequest = new SendSmsRequest();
            sendSmsRequest.setTemplateParam(JSON.toJSONString(value));
            sendSmsRequest.setSignName(smsConfig.getTemplateName());
            sendSmsRequest.setTemplateCode(smsConfig.getTemplate());
            sendSmsRequest.setPhoneNumbers(telephone);
            SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
            SendSmsResponseBody smsResponseBody = sendSmsResponse.getBody();
            logger.info("手机号：{},发送结果：{}", telephone ,smsResponseBody.getMessage());
            return smsResponseBody.getCode().equals("OK");
            //isv.AMOUNT_NOT_ENOUGH 余额不足
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("手机号：{},发送错误信息：{}", telephone ,e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean verifySms(String phone, String code) {
        if (redisUtil.isExists(phoneName+phone)) {
            String redisCode = redisUtil.read(phoneName+phone).toString();
            return redisCode.equals(code);
        }
        return false;
    }
}

