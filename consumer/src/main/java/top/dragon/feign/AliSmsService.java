package top.dragon.feign;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("ali-cloud")
public interface AliSmsService {

    @GetMapping("/sms/send")
    Boolean sendSms( @RequestParam String phone);


    @GetMapping("/sms/verify")
    Boolean verifySms(@RequestParam String phone,@RequestParam String code);
}
