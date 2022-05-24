package top.dragon.feign;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "master-worker")
public interface WorkerService {

    @GetMapping("/worker/isExistByUserId")
    ResponseEntity<Boolean> isExistByUserId(@RequestParam("userId") Long userId);

}
