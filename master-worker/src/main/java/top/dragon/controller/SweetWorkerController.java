package top.dragon.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetWorker;
import top.dragon.service.SweetWorkerService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 工人列表 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/worker")
@Api(tags = "工人管理")
public class SweetWorkerController {
    @Resource
    private SweetWorkerService sweetWorkerService;

    @PostMapping("/getWorkerList")
    @ApiOperation("获取工人列表")
    public ResponseEntity<ResultEntity> getWorkerList(@RequestBody PageEntity pageEntity, @RequestBody ConditionQueryEntity conditionQueryEntity){
        return ResponseEntity.ok(sweetWorkerService.getWorkerList(pageEntity,conditionQueryEntity));
    }
    @GetMapping("/getWorkerInfo")
    @ApiOperation("获取工人信息")
    public ResponseEntity<ResultEntity> getWorkerInfo(HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        SweetWorker workerInfo = sweetWorkerService.getWorkerInfo(userId);
        return ResponseEntity.ok(ResultEntity.isValid(workerInfo!=null,"查询成功","查询失败",workerInfo));
    }
    @GetMapping("/getWorkerByIdInfo")
    @ApiOperation("根据id获取工人信息")
    public SweetWorker getWorkerByIdInfo(HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return sweetWorkerService.getWorkerInfo(userId);
    }

    @GetMapping("isExistByUserId")
    @ApiOperation("根据id获取是否是工人")
    public ResponseEntity<Boolean> isExistByUserId(@RequestParam("userId") Long userId){
        return  ResponseEntity.ok(sweetWorkerService.isExistByUserId(userId));
    }

    @PostMapping("createWorker")
    @ApiOperation("创建工人")
    public ResponseEntity<ResultEntity> createWorker(@RequestBody SweetWorker sweetWorker,HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        sweetWorker.setWorkerUid(userId);
        return ResponseEntity.ok(sweetWorkerService.addWorker(sweetWorker));
    }
    @PostMapping("/addWorker")
    @ApiOperation("添加工人")
    public ResponseEntity<ResultEntity> addWorker(@RequestBody SweetWorker sweetWorker){
        return ResponseEntity.ok(sweetWorkerService.addWorker(sweetWorker));
    }

    @PostMapping("/updateWorker")
    @ApiOperation("修改工人信息")
    public ResponseEntity<ResultEntity> updateWorker(@RequestBody SweetWorker sweetWorker){
        return ResponseEntity.ok(sweetWorkerService.updateWorker(sweetWorker));
    }
    @PostMapping("/deleteWorker")
    @ApiOperation("删除工人")
    public ResponseEntity<ResultEntity> deleteWorker(@RequestBody SweetWorker sweetWorker){
        return ResponseEntity.ok(sweetWorkerService.deleteWorker(sweetWorker));
    }

//     TODO:工人交付保证金
//    @PostMapping("deposit")
//    @ApiOperation("工人保证金")
//    public ResponseEntity<ResultEntity> deposit(@RequestBody SweetWorker sweetWorker){
//        return ResponseEntity.ok(sweetWorkerService.deposit(sweetWorker));
//    }


}

