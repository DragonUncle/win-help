package top.dragon.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetGoodsShopPicture;
import top.dragon.service.SweetGoodsShopPictureService;
import top.dragon.service.SweetGoodsShopService;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-22
 */
@RestController
@RequestMapping("/goodsShopPicture")
@Api(tags = "商家图片接口")
public class SweetGoodsShopPictureController {
    @Resource
    private SweetGoodsShopPictureService goodsShopPictureService;

    @PostMapping("getAll")
    @ApiOperation("获取所有商家图片")
    public ResponseEntity<ResultEntity> getAll(@RequestBody PageEntity pageEntity,@RequestBody ConditionQueryEntity conditionQueryEntity){
         return  ResponseEntity.ok(goodsShopPictureService.getAll(pageEntity,conditionQueryEntity));
    }

    @PostMapping("getShopId")
    @ApiOperation("获取商家id")
    public ResponseEntity<ResultEntity> getShopId(@RequestParam("shopId") Long shopId){
        return ResponseEntity.ok(goodsShopPictureService.getShopId(shopId));
    }

    @PostMapping("add")
    @ApiOperation("添加商家图片")
    public ResponseEntity<ResultEntity> add(@RequestBody SweetGoodsShopPicture goodsShopPicture){
        return ResponseEntity.ok(goodsShopPictureService.add(goodsShopPicture));
    }

    @PostMapping("change")
    @ApiOperation("修改商家图片")
    public ResponseEntity<ResultEntity> change(@RequestBody SweetGoodsShopPicture goodsShopPicture){
        return ResponseEntity.ok(goodsShopPictureService.change(goodsShopPicture));
    }

    @PostMapping("delete")
    @ApiOperation("删除商家图片")
    public ResponseEntity<ResultEntity> delete(@RequestParam("id") Long id){
        return ResponseEntity.ok(goodsShopPictureService.delete(id));
    }


}

