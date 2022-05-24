package top.dragon.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetNeedOrder;
import top.dragon.service.SweetNeedOrderService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 需求列表 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/needOrder")
@Api(tags = "需求列表")
public class SweetNeedOrderController {

    @Resource
    private SweetNeedOrderService needOrderService;

    @PostMapping("/getAll")
    @ApiOperation("获取所有需求")
    public ResponseEntity<ResultEntity> getAll(@RequestBody PageEntity pageEntity, @RequestBody ConditionQueryEntity conditionQueryEntity){
        return ResponseEntity.ok(needOrderService.getAll(pageEntity, conditionQueryEntity));
    }

    @GetMapping("/getById")
    @ApiOperation("根据id获取需求")
    public ResponseEntity<ResultEntity> getNeedById(@RequestParam("needId") Integer needId){
        return ResponseEntity.ok(needOrderService.getNeedById(needId));
    }

    @PostMapping("/getByUserId")
    @ApiOperation("根据用户id获取需求")
    public ResponseEntity<ResultEntity> getNeedByUserId(@RequestBody PageEntity pageEntity, HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(needOrderService.getNeedByUserId(pageEntity, userId));
    }

    @PostMapping("add")
    @ApiOperation("添加需求")
    public ResponseEntity<ResultEntity> addNeed(
            @RequestBody SweetNeedOrder needOrder,
            @RequestBody List<Integer> classifyIds,
            HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        needOrder.setNeedUid(userId);
        return ResponseEntity.ok(needOrderService.addNeed(needOrder,classifyIds));
    }

    @PostMapping("/change")
    @ApiOperation("修改需求")
    public ResponseEntity<ResultEntity> changeNeed(@RequestBody SweetNeedOrder needOrder,HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(needOrderService.changeNeed(needOrder,userId));
    }

    @PostMapping("/delete")
    @ApiOperation("删除需求")
    public ResponseEntity<ResultEntity> deleteNeed(@RequestBody SweetNeedOrder needOrder,HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(needOrderService.deleteNeed(needOrder,userId));
    }


}

