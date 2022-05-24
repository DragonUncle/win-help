package top.dragon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "merchant")
public interface MerchantService {

    @GetMapping("/goodsShop/isExistByUserId")
    ResponseEntity<Boolean> isExistByUserId(@RequestParam("userId") Long userId);
}
