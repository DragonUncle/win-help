package top.dragon.service;

import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetWorkerComment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 工人评论 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
public interface SweetWorkerCommentService extends IService<SweetWorkerComment> {

    ResultEntity getAll(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity);

    ResultEntity write(SweetWorkerComment workerComment);

    ResultEntity delete(SweetWorkerComment workerComment, Long userId);

    ResultEntity change(SweetWorkerComment workerComment, Long userId);

    ResultEntity getByWorkerId(PageEntity pageEntity, Integer workerId);

    ResultEntity getByUserId(PageEntity pageEntity, Long userId);
}
