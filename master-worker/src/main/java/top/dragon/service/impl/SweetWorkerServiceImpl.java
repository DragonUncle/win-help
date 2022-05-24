package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsonwebtoken.lang.Collections;
import org.apache.commons.lang3.StringUtils;
import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetWorker;
import top.dragon.mapper.SweetWorkerMapper;
import top.dragon.service.SweetWorkerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 工人列表 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Service
public class SweetWorkerServiceImpl extends ServiceImpl<SweetWorkerMapper, SweetWorker> implements SweetWorkerService {

    @Override
    public ResultEntity getWorkerList(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity) {
        QueryWrapper<SweetWorker> workerSql = new QueryWrapper<SweetWorker>().eq("worker_is_del", false);
        List<String> likeNames = conditionQueryEntity.getLikeName();
        if (!Collections.isEmpty(likeNames))
            likeNames.forEach(name -> workerSql.like(name, conditionQueryEntity.getLikeValue()));
        Map<String, String> sortMap = conditionQueryEntity.getSortMap();
        if (!Collections.isEmpty(sortMap))
            sortMap.forEach((key, value) -> workerSql.orderBy(true, value.equals("asc"), key));
        return ResultEntity.succeed(this.page(new Page<>(pageEntity.getPage(), pageEntity.getLimit()), workerSql));
    }

    @Override
    public SweetWorker getWorkerInfo(Long userId) {
        return this.getOne(new QueryWrapper<SweetWorker>().eq("worker_uid", userId));
    }

    @Override
    public ResultEntity addWorker(SweetWorker sweetWorker) {
        if (sweetWorker.getWorkerUid() == null)
            return ResultEntity.error("用户id不能为空");
        if (StringUtils.isAnyBlank(sweetWorker.getWorkerRealName(), sweetWorker.getWorkerPhone()))
            return ResultEntity.error("姓名或手机号不能为空");
        if (StringUtils.isAnyBlank(sweetWorker.getWorkerCardFront(), sweetWorker.getWorkerCardBack()))
            return ResultEntity.error("身份证正反面不能为空");
        if (StringUtils.isAnyBlank(sweetWorker.getWorkerArea(),sweetWorker.getWorkerAddress()))
            return ResultEntity.error("工作地址不能为空");
        sweetWorker.setWorkerFinishOrderCount(0);
        sweetWorker.setWorkerIsDel(false);
        sweetWorker.setWorkerStatus(0);
        sweetWorker.setWorkerCancelOrderCount(0);
        sweetWorker.setWorkerEvaluate(0);
        sweetWorker.setWorkerIsShow(true);
        return ResultEntity.isValid(this.save(sweetWorker), "添加成功", "添加失败");
    }

    @Override
    public ResultEntity updateWorker(SweetWorker sweetWorker) {
        return ResultEntity.isValid(this.updateById(sweetWorker), "修改成功", "修改失败");
    }

    @Override
    public ResultEntity deleteWorker(SweetWorker sweetWorker) {
        if (sweetWorker != null &&sweetWorker.getWorkerUid() == null) {
            SweetWorker byId = this.getById(sweetWorker.getWorkerId());
            byId.setWorkerIsDel(true);
            return ResultEntity.isValid(this.updateById(byId), "删除成功", "删除失败");
        }
        return ResultEntity.error("删除失败");
    }

    @Override
    public Boolean isExistByUserId(Long userId) {
        SweetWorker worker = this.getOne(new QueryWrapper<SweetWorker>()
                .eq("worker_is_del", false)
                .eq("worker_uid", userId)
                .eq("worker_status", 1));

        return worker != null;
    }
}
