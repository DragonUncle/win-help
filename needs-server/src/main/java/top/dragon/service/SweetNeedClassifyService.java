package top.dragon.service;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetNeedClassify;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务分类 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
public interface SweetNeedClassifyService extends IService<SweetNeedClassify> {

    ResultEntity getAllClassify(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity);

    ResultEntity getClassifyById(Integer classifyId);

    ResultEntity addClassify(SweetNeedClassify conditionQueryEntity);

    ResultEntity changeClassify(SweetNeedClassify conditionQueryEntity);

    ResultEntity deleteClassify(SweetNeedClassify conditionQueryEntity);
}
