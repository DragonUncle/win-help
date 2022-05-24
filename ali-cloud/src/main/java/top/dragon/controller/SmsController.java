package top.dragon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import top.dragon.server.SmsService;

import javax.annotation.Resource;


@RestController
@Api(tags = "短信接口")
@RequestMapping("/sms")
public class SmsController {

    @Resource
    private SmsService smsService;
    @GetMapping("/send")
    @ApiOperation(value = "发送短信")
    public Boolean sendSms(
            @ApiParam(value = "手机号") @RequestParam String phone) {
        return smsService.sendSms(phone);
    }
    @GetMapping("/verify")
    @ApiOperation(value = "验证短信")
    public Boolean verifySms(
            @ApiParam(value = "手机号")@RequestParam String phone,
            @ApiParam(value = "验证码")@RequestParam String code) {
        return smsService.verifySms(phone,code);
    }
}
