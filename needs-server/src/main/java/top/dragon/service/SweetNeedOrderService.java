package top.dragon.service;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetNeedOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 需求列表 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
public interface SweetNeedOrderService extends IService<SweetNeedOrder> {


    ResultEntity getAll(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity);

    ResultEntity getNeedById(Integer needId);

    ResultEntity getNeedByUserId(PageEntity pageEntity, Long userId);

    ResultEntity addNeed(SweetNeedOrder needOrder, List<Integer> classifyIds);

    ResultEntity changeNeed(SweetNeedOrder needOrder, Long userId);

    ResultEntity deleteNeed(SweetNeedOrder needOrder, Long userId);
}
