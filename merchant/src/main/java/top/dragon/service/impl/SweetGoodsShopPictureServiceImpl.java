package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsonwebtoken.lang.Collections;
import org.apache.commons.lang3.StringUtils;
import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetGoodsShopPicture;
import top.dragon.mapper.SweetGoodsShopPictureMapper;
import top.dragon.service.SweetGoodsShopPictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-22
 */
@Service
public class SweetGoodsShopPictureServiceImpl extends ServiceImpl<SweetGoodsShopPictureMapper, SweetGoodsShopPicture> implements SweetGoodsShopPictureService {

    @Override
    public ResultEntity getAll(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity) {

        QueryWrapper<SweetGoodsShopPicture> pictureSql = new QueryWrapper<SweetGoodsShopPicture>()
                .eq("shop_picture_is_del", false);
        List<String> likeNames = conditionQueryEntity.getLikeName();
        if(!Collections.isEmpty(likeNames)){
            likeNames.forEach(name -> {pictureSql.like(name, conditionQueryEntity.getLikeValue());});
        }
        Map<String, String> sortMap = conditionQueryEntity.getSortMap();
        if(!Collections.isEmpty(sortMap)){
            sortMap.forEach((key, value) -> {pictureSql.orderBy(true, value.equals("asc"), key);});
        }
        return ResultEntity.succeed(this.page(new Page<>(pageEntity.getPage(), pageEntity.getLimit()), pictureSql));
    }

    @Override
    public ResultEntity getShopId(Long shopId) {
        QueryWrapper<SweetGoodsShopPicture> pictureSql = new QueryWrapper<SweetGoodsShopPicture>()
                .eq("shop_picture_is_del", false)
                .eq("shop_picture_sid", shopId);
        return ResultEntity.succeed(this.list(pictureSql));
    }
    @Override
    public ResultEntity add(SweetGoodsShopPicture goodsShopPicture) {
        if (goodsShopPicture.getShopPictureSid() == null) return ResultEntity.error("店铺id不能为空");
        if (StringUtils.isAnyBlank(goodsShopPicture.getShopPictureUrl())) return ResultEntity.error("图片地址不能为空");
        if (goodsShopPicture.getShopPictureSort() == null) goodsShopPicture.setShopPictureSort(0);
        goodsShopPicture.setShopPictureIsShow(true);
        goodsShopPicture.setShopPictureIsDel(false);
        goodsShopPicture.setShopPictureCreateTime(LocalDateTime.now());
        return ResultEntity.isValid(this.save(goodsShopPicture), "添加成功", "添加失败");
    }

    @Override
    public ResultEntity change(SweetGoodsShopPicture goodsShopPicture) {
        return null;
    }

    @Override
    public ResultEntity delete(Long id) {
        return null;
    }
}
