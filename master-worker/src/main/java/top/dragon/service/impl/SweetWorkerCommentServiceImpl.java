package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsonwebtoken.lang.Collections;
import org.apache.commons.lang3.StringUtils;
import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetWorkerComment;
import top.dragon.mapper.SweetWorkerCommentMapper;
import top.dragon.service.SweetWorkerCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 工人评论 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Service
public class SweetWorkerCommentServiceImpl extends ServiceImpl<SweetWorkerCommentMapper, SweetWorkerComment> implements SweetWorkerCommentService {

    @Override
    public ResultEntity getAll(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity) {
        QueryWrapper<SweetWorkerComment> commentSql = new QueryWrapper<SweetWorkerComment>()
                .eq("worker_comment_is_del", false);
        List<String> likeNames = conditionQueryEntity.getLikeName();
        if (!Collections.isEmpty(likeNames))
            likeNames.forEach(name -> commentSql.like(name, conditionQueryEntity.getLikeValue()));
        Map<String, String> sortMap = conditionQueryEntity.getSortMap();
        if (!Collections.isEmpty(sortMap))
            sortMap.forEach((key, value) -> commentSql.orderBy(true, value.equals("asc"), key));
        return ResultEntity.succeed(this.page(new Page<SweetWorkerComment>(pageEntity.getPage(), pageEntity.getLimit()), commentSql));
    }

    @Override
    public ResultEntity write(SweetWorkerComment workerComment) {
        if (workerComment.getWorkerCommentId() == null)return ResultEntity.error("评论id不能为空");
        if (workerComment.getWorkerCommentUid() == null)return ResultEntity.error("评论用户id不能为空");
        if (StringUtils.isBlank(workerComment.getWorkerCommentDetails()))return ResultEntity.error("评论内容不能为空");
        if (workerComment.getWorkerCommentEvaluate()!= null && workerComment.getWorkerCommentEvaluate() < 0)return ResultEntity.error("评论等级不能为负数");
        if (workerComment.getWorkerCommentEvaluate()!= null && workerComment.getWorkerCommentEvaluate() > 5)return ResultEntity.error("评论等级不能大于5");
        workerComment.setWorkerCommentIsDel(false);
        workerComment.setWorkerCommentIsShow(false);
        return ResultEntity.isValid(this.save(workerComment), "评论成功", "评论失败");
    }

    @Override
    public ResultEntity delete(SweetWorkerComment workerComment, Long userId) {
        if (workerComment.getWorkerCommentId() == null)return ResultEntity.error("评论id不能为空");
        if (workerComment.getWorkerCommentUid() == null)return ResultEntity.error("评论用户id不能为空");
        if (!workerComment.getWorkerCommentUid().equals(userId))return ResultEntity.error("只能删除自己的评论");
        workerComment.setWorkerCommentIsDel(true);
        return ResultEntity.isValid(this.updateById(workerComment), "删除成功", "删除失败");
    }

    @Override
    public ResultEntity change(SweetWorkerComment workerComment, Long userId) {
        if (workerComment.getWorkerCommentId() == null)return ResultEntity.error("评论id不能为空");
        if (workerComment.getWorkerCommentUid() == null)return ResultEntity.error("评论用户id不能为空");
        if (!workerComment.getWorkerCommentUid().equals(userId))return ResultEntity.error("只能修改自己的评论");
        return ResultEntity.isValid(this.updateById(workerComment), "修改成功", "修改失败");
    }

    @Override
    public ResultEntity getByWorkerId(PageEntity pageEntity, Integer workerId) {
        QueryWrapper<SweetWorkerComment> commentSql = new QueryWrapper<SweetWorkerComment>()
                .eq("worker_comment_is_del", false)
                .eq("worker_comment_wid", workerId).orderByDesc("worker_comment_create_time");
        return ResultEntity.succeed(this.page(new Page<SweetWorkerComment>(pageEntity.getPage(), pageEntity.getLimit()), commentSql));
    }

    @Override
    public ResultEntity getByUserId(PageEntity pageEntity, Long userId) {
        QueryWrapper<SweetWorkerComment> commentSql = new QueryWrapper<SweetWorkerComment>()
                .eq("worker_comment_is_del", false)
                .eq("worker_comment_uid", userId).orderByDesc("worker_comment_create_time");
        return ResultEntity.succeed(this.page(new Page<SweetWorkerComment>(pageEntity.getPage(), pageEntity.getLimit()), commentSql));
    }
}
