package top.dragon.server;

import top.dragon.entity.AliSmsConfig;

import java.util.Map;

public interface SmsService {
   Boolean sendSms(String phone);

   /**
    * 发送短信
    * @param telephone 手机号
    * @param value     内容
    * @param smsConfig 配置信息
    * @return 发送是否成功
    */
   Boolean send(String telephone, Map<String,String> value, AliSmsConfig smsConfig);


   Boolean verifySms(String phone, String code);

}
