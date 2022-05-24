package top.dragon.service;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetGoodsShopPicture;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-22
 */
public interface SweetGoodsShopPictureService extends IService<SweetGoodsShopPicture> {

    ResultEntity getAll(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity);

    ResultEntity getShopId(Long shopId);

    ResultEntity add(SweetGoodsShopPicture goodsShopPicture);

    ResultEntity change(SweetGoodsShopPicture goodsShopPicture);

    ResultEntity delete(Long id);
}
