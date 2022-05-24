package top.dragon.service;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetWorker;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 工人列表 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
public interface SweetWorkerService extends IService<SweetWorker> {


    ResultEntity getWorkerList(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity);

    SweetWorker getWorkerInfo(Long userId);

    ResultEntity addWorker(SweetWorker sweetWorker);

    ResultEntity updateWorker(SweetWorker sweetWorker);

    ResultEntity deleteWorker(SweetWorker sweetWorker);

    Boolean isExistByUserId(Long userId);
}
