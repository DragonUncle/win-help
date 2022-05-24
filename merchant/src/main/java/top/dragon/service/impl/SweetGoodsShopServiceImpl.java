package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsonwebtoken.lang.Collections;
import org.apache.commons.lang3.StringUtils;
import top.dragon.entity.*;
import top.dragon.mapper.SweetGoodsShopMapper;
import top.dragon.service.SweetGoodsShopPictureService;
import top.dragon.service.SweetGoodsShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 商户 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-22
 */
@Service
public class SweetGoodsShopServiceImpl extends ServiceImpl<SweetGoodsShopMapper, SweetGoodsShop> implements SweetGoodsShopService {


    @Resource
    private SweetGoodsShopPictureService goodsShopPictureService;

    @Override
    public ResultEntity getAll(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity) {


        QueryWrapper<SweetGoodsShop> shopSql = new QueryWrapper<SweetGoodsShop>().eq("shop_is_del", false);
        List<String> likeNames = conditionQueryEntity.getLikeName();
        if (!Collections.isEmpty(likeNames))
            likeNames.forEach(name -> shopSql.like( name, conditionQueryEntity.getLikeValue()) );
        Map<String, String> sortMap = conditionQueryEntity.getSortMap();
        if (!Collections.isEmpty(sortMap))
            sortMap.forEach( (k,v) -> shopSql.orderBy(true, v.equals("asc"), k) );
        Page<SweetGoodsShop> shopPage = this.page(new Page<>(pageEntity.getPage(), pageEntity.getLimit()), shopSql);
        shopPage.getRecords().forEach(shop -> {
            List<SweetGoodsShopPicture> pictures = goodsShopPictureService.list(new QueryWrapper<>(
                    new SweetGoodsShopPicture()).eq("shop_picture_is_del", false)
                    .eq("shop_picture_sid", shop.getShopId()).orderByAsc("shop_picture_sort"));
            shop.setShopImage(pictures.stream().map(SweetGoodsShopPicture::getShopPictureUrl).collect(Collectors.toList()));
        });
        return ResultEntity.succeed(shopPage);
    }

    @Override
    public ResultEntity getShopById(Long shopId) {
        SweetGoodsShop goodsShop = this.getById(shopId);
        if (goodsShop == null)return ResultEntity.error("商户不存在");
        List<SweetGoodsShopPicture> pictures = goodsShopPictureService.list(new QueryWrapper<>(
                new SweetGoodsShopPicture()).eq("shop_picture_is_del", false)
                .eq("shop_picture_sid", goodsShop.getShopId()).orderByAsc("shop_picture_sort"));
        goodsShop.setShopImage(pictures.stream().map(SweetGoodsShopPicture::getShopPictureUrl).collect(Collectors.toList()));
        return ResultEntity.succeed(goodsShop);
    }

    @Override
    public ResultEntity add(SweetGoodsShop goodsShop,  Long shopId) {
        if (StringUtils.isAnyBlank(goodsShop.getShopName(), goodsShop.getShopAddress(), goodsShop.getShopTelephone()))
            return ResultEntity.error("商户信息不完整");
        if (StringUtils.isAnyBlank(goodsShop.getShopCorpnIdentityCardFront(), goodsShop.getShopCorpnIdentityCardBack()))
            return ResultEntity.error("身份证不完整");
        if (StringUtils.isAnyBlank(goodsShop.getShopLicense(), goodsShop.getShopBoss()))
            return ResultEntity.error("营业执照不完整");
        goodsShop.setShopCreateTime(LocalDateTime.now());
        goodsShop.setShopIsDel(false);
        goodsShop.setShopUid(shopId);
        goodsShop.setShopIsShow(false);
        goodsShop.setShopStatus(0);
        if (this.save(goodsShop)) {
            List<String> shopImage = goodsShop.getShopImage();
            if (!Collections.isEmpty(shopImage)){
                shopImage.forEach(url -> {
                    SweetGoodsShopPicture shopPicture = new SweetGoodsShopPicture().setShopPictureSid(goodsShop.getShopId())
                            .setShopPictureIsDel(false).setShopPictureIsShow(true).setShopPictureUrl(url)
                            .setShopPictureSort(0).setShopPictureCreateTime(LocalDateTime.now());
                    goodsShopPictureService.save(shopPicture);
                });
            }
            return ResultEntity.succeed("添加成功");
        }else{
            return ResultEntity.error("添加失败");
        }
    }

    @Override
    public ResultEntity change(SweetGoodsShop goodsShop, Long shopId) {
        return null;
    }

    @Override
    public ResultEntity del(SweetGoodsShop goodsShop, Long shopId) {
        return null;
    }

    @Override
    public ResultEntity getByUserId(Long userId) {
        return ResultEntity.succeed(this.list(new QueryWrapper<SweetGoodsShop>().eq("shop_uid", userId)));
    }

    @Override
    public Boolean isExistByUserId(Long userId) {

        SweetGoodsShop goodsShop = this.getOne(new QueryWrapper<SweetGoodsShop>()
                .eq("shop_is_del", false)
                .eq("shop_uid", userId)
                .eq("shop_status", 1));
        return goodsShop != null;
    }
}
