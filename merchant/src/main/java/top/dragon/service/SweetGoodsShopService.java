package top.dragon.service;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetGoodsShop;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商户 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-22
 */
public interface SweetGoodsShopService extends IService<SweetGoodsShop> {

    ResultEntity getAll(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity);

    ResultEntity getShopById(Long shopId);

    ResultEntity add(SweetGoodsShop goodsShop, Long shopId);

    ResultEntity change(SweetGoodsShop goodsShop, Long shopId);

    ResultEntity del(SweetGoodsShop goodsShop, Long shopId);

    ResultEntity getByUserId(Long userId);

    Boolean isExistByUserId(Long userId);
}
