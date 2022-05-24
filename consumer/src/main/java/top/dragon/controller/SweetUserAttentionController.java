package top.dragon.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.service.SweetUserAttentionService;

import javax.annotation.Resource;

/**
 * <p>
 * 用户关注 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-13
 */
@RestController
@RequestMapping("/attention")
public class SweetUserAttentionController {
//    @Resource
//    private SweetUserAttentionService userAttentionService;


    public ResponseEntity<ResultEntity> getList(@RequestBody PageEntity pageEntity) {
        //return ResponseEntity.ok(userAttentionService.getList(pageEntity));

        return null;
    }
}

