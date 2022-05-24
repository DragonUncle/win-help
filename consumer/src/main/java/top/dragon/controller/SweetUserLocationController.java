package top.dragon.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetUserLocation;
import top.dragon.service.SweetUserLocationService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户收货地址 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/location")
@Api(tags = "用户收货地址")

public class SweetUserLocationController {

    @Resource
    private SweetUserLocationService sweetUserLocationService;
    @PostMapping("list")
    @ApiOperation(value = "查询用户收货地址列表")
    public ResponseEntity<ResultEntity> getAll(@RequestBody PageEntity pageEntity,HttpServletRequest request){
        Long userId = Long.valueOf(request.getHeader("userId"));
        return ResponseEntity.ok(sweetUserLocationService.getAll(pageEntity,userId));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加用户收货地址")
    public ResponseEntity<ResultEntity> add(@RequestBody SweetUserLocation sweetUserLocation, HttpServletRequest request){
        Long userId = Long.valueOf(request.getHeader("userId"));
        return ResponseEntity.ok(sweetUserLocationService.add(sweetUserLocation,userId));
    }

    @PostMapping("/change")
    @ApiOperation(value = "修改用户收货地址")
    public ResponseEntity<ResultEntity> change(@RequestBody SweetUserLocation sweetUserLocation, HttpServletRequest request){
        Long userId = Long.valueOf(request.getHeader("userId"));
        return ResponseEntity.ok(sweetUserLocationService.change(sweetUserLocation,userId));
    }
    @PostMapping("/delete")
    @ApiOperation(value = "删除用户收货地址")
    public ResponseEntity<ResultEntity> delete(@RequestBody SweetUserLocation sweetUserLocation, HttpServletRequest request){
        Long userId = Long.valueOf(request.getHeader("userId"));
        return ResponseEntity.ok(sweetUserLocationService.delete(sweetUserLocation,userId));
    }




}

