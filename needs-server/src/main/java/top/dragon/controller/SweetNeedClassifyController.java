package top.dragon.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetNeedClassify;
import top.dragon.service.SweetNeedClassifyService;

import javax.annotation.Resource;

/**
 * <p>
 * 服务分类 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/needClassify")
@Api(tags = "需求服务分类")
public class SweetNeedClassifyController {

    @Resource
    private SweetNeedClassifyService sweetNeedClassifyService;

    @PostMapping("/getAll")
    @ApiOperation("获取所有分类")
    public ResponseEntity<ResultEntity> getAllClassify(@RequestBody PageEntity pageEntity, @RequestBody ConditionQueryEntity conditionQueryEntity){
        return ResponseEntity.ok(sweetNeedClassifyService.getAllClassify(pageEntity, conditionQueryEntity));
    }
    @GetMapping("/getById")
    @ApiOperation("根据id获取分类")
    public ResponseEntity<ResultEntity> getClassifyById(@RequestParam("classifyId") Integer classifyId){
        return ResponseEntity.ok(sweetNeedClassifyService.getClassifyById(classifyId));
    }
    @PostMapping("/add")
    @ApiOperation("添加分类")
    public ResponseEntity<ResultEntity> addClassify(@RequestBody SweetNeedClassify needClassify){
        return ResponseEntity.ok(sweetNeedClassifyService.addClassify(needClassify));
    }
    @PostMapping("/change")
    @ApiOperation("修改分类")
    public ResponseEntity<ResultEntity> changeClassify(@RequestBody SweetNeedClassify needClassify){
        return ResponseEntity.ok(sweetNeedClassifyService.changeClassify(needClassify));
    }
    @PostMapping("/delete")
    @ApiOperation("删除分类")
    public ResponseEntity<ResultEntity> deleteClassify(@RequestBody SweetNeedClassify needClassify){
        return ResponseEntity.ok(sweetNeedClassifyService.deleteClassify(needClassify));
    }
}

