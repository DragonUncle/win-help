package top.dragon.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetWorkerComment;
import top.dragon.service.SweetWorkerCommentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 工人评论 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@RestController
@RequestMapping("/worker-comment")
@Api(tags = "工人评论")
public class SweetWorkerCommentController {

    @Resource
    private SweetWorkerCommentService workerCommentService;

    @PostMapping("/getAll")
    @ApiOperation("获取所有评论")
    public ResponseEntity<ResultEntity> getAll(@RequestBody PageEntity pageEntity, @RequestBody ConditionQueryEntity conditionQueryEntity){
        return ResponseEntity.ok(workerCommentService.getAll(pageEntity, conditionQueryEntity));
    }

    @PostMapping("/write")
    @ApiOperation("写评论")
    public ResponseEntity<ResultEntity> write(@RequestBody SweetWorkerComment workerComment, HttpServletRequest request){
        Long userId = Long.valueOf(request.getHeader("userId"));
        workerComment.setWorkerCommentUid(userId);
        return ResponseEntity.ok(workerCommentService.write(workerComment));
    }

    @PostMapping("/delete")
    @ApiOperation("删除评论")
    public ResponseEntity<ResultEntity> delete(@RequestBody SweetWorkerComment workerComment, HttpServletRequest request){
        Long userId = Long.valueOf(request.getHeader("userId"));
        return ResponseEntity.ok(workerCommentService.delete(workerComment,userId));
    }

    @PostMapping("/change")
    @ApiOperation("修改评论")
    public ResponseEntity<ResultEntity> change(@RequestBody SweetWorkerComment workerComment, HttpServletRequest request){
        Long userId = Long.valueOf(request.getHeader("userId"));
        return ResponseEntity.ok(workerCommentService.change(workerComment,userId));
    }

    @PostMapping("/getByWorkerId")
    @ApiOperation("获取工人的评论")
    public ResponseEntity<ResultEntity> getByWorkerId(@RequestBody PageEntity pageEntity, @RequestParam("workerId") Integer workerId){
        return ResponseEntity.ok(workerCommentService.getByWorkerId(pageEntity, workerId));
    }

    @PostMapping("/getByUserId")
    @ApiOperation("获取用户的评论")
    public ResponseEntity<ResultEntity> getByUserId(@RequestBody PageEntity pageEntity, HttpServletRequest request){
        Long userId = Long.valueOf(request.getHeader("userId"));
        return ResponseEntity.ok(workerCommentService.getByUserId(pageEntity, userId));
    }

}

