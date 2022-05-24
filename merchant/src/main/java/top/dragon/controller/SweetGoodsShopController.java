package top.dragon.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetGoodsShop;
import top.dragon.service.SweetGoodsShopService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 商户 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-22
 */
@RestController
@RequestMapping("/goodsShop")
@Api(tags = "商户")
public class SweetGoodsShopController {


    @Resource
    private SweetGoodsShopService goodsShopService;

    @PostMapping("getAll")
    @ApiOperation("获取所有商户")
    public ResponseEntity<ResultEntity> getAll(@RequestBody PageEntity pageEntity, @RequestBody ConditionQueryEntity conditionQueryEntity){
        return ResponseEntity.ok(goodsShopService.getAll(pageEntity,conditionQueryEntity));
    }

    @GetMapping("getMyShop")
    @ApiOperation("获取我的商户")
    public ResponseEntity<ResultEntity> getMyShop(HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(goodsShopService.getByUserId(userId));
    }

    @GetMapping("getById")
    @ApiOperation("根据id获取商户")
    public ResponseEntity<ResultEntity> getById(@RequestParam("shopId") Long shopId){
        return ResponseEntity.ok(goodsShopService.getShopById(shopId));
    }

    @GetMapping("isExistByUserId")
    @ApiOperation("根据用户id判断是否存在商户")
    public ResponseEntity<Boolean> isExistByUserId(@RequestParam("userId") Long userId){
        return ResponseEntity.ok(goodsShopService.isExistByUserId(userId));
    }

    @GetMapping("getByUserId")
    @ApiOperation("根据用户id获取商户")
    public ResponseEntity<ResultEntity> getByUserId(@RequestParam("userId") Long userId){
        return ResponseEntity.ok(goodsShopService.getByUserId(userId));
    }

    @PostMapping("add")
    @ApiOperation("添加商户")
    public ResponseEntity<ResultEntity> add(@RequestBody SweetGoodsShop goodsShop,  HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(goodsShopService.add(goodsShop,userId));
    }
    @PostMapping("change")
    @ApiOperation("修改商户")
    public ResponseEntity<ResultEntity> change(@RequestBody SweetGoodsShop goodsShop, HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(goodsShopService.change(goodsShop,userId));
    }
    @PostMapping("del")
    @ApiOperation("删除商户")
    public ResponseEntity<ResultEntity> del(@RequestBody SweetGoodsShop goodsShop, HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(goodsShopService.del(goodsShop,userId));
    }
}

