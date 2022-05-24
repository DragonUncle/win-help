package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsonwebtoken.lang.Collections;
import org.apache.commons.lang3.StringUtils;
import top.dragon.entity.*;
import top.dragon.mapper.SweetNeedOrderMapper;
import top.dragon.service.SweetNeedClassifyService;
import top.dragon.service.SweetNeedOrderClassifyService;
import top.dragon.service.SweetNeedOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 需求列表 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Service
public class SweetNeedOrderServiceImpl extends ServiceImpl<SweetNeedOrderMapper, SweetNeedOrder> implements SweetNeedOrderService {

    @Resource
    private SweetNeedClassifyService needClassifyService;

    @Resource
    private SweetNeedOrderClassifyService orderClassifyService;

    @Override
    public ResultEntity getAll(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity) {

        QueryWrapper<SweetNeedOrder> needOrderSql = new QueryWrapper<SweetNeedOrder>()
                .eq("need_user_is_del", false).or().eq("need_worker_is_del", false);
        List<String> likeNames = conditionQueryEntity.getLikeName();
        if(!Collections.isEmpty(likeNames))
            likeNames.forEach(name -> needOrderSql.like( name, conditionQueryEntity.getLikeValue()) );
        Map<String, String> sortMap = conditionQueryEntity.getSortMap();
        if(!Collections.isEmpty(sortMap))
            sortMap.forEach( (key, value) -> needOrderSql.orderBy(true, value.equals("asc"), key));
        Page<SweetNeedOrder> page = this.page(new Page<>(pageEntity.getPage(), pageEntity.getLimit()), needOrderSql);
        ArrayList<Map<String, Object>> resultList = new ArrayList<>();
        List<SweetNeedOrder> records = page.getRecords();
        records.forEach(v->{
            try {
                Map<String, Object> tempMap = new HashMap<>();
                tempMap.put("needOrder",v);
                List<SweetNeedOrderClassify> classifyOid = orderClassifyService.list(
                        new QueryWrapper<SweetNeedOrderClassify>().eq("need_order_classify_oid", v.getNeedId()));
                classifyOid.forEach(v1->{
                    SweetNeedClassify classify = needClassifyService.getById(v1.getNeedOrderClassifyCid());
                    v1.setNeedOrderClassifyName(classify.getServerClassifyName());
                });
                tempMap.put("needClassifyList", classifyOid);
                resultList.add(tempMap);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        return ResultEntity.succeed(new IPage<Map<String, Object>>() {
            @Override
            public List<OrderItem> orders() {
                return page.orders();
            }

            @Override
            public List<Map<String, Object>> getRecords() {
                return resultList;
            }

            @Override
            public IPage<Map<String, Object>> setRecords(List<Map<String, Object>> records) {
                return null;
            }

            @Override
            public long getTotal() {
                return page.getTotal();
            }

            @Override
            public IPage<Map<String, Object>> setTotal(long total) {
                return null;
            }

            @Override
            public long getSize() {
                return page.getSize();
            }

            @Override
            public IPage<Map<String, Object>> setSize(long size) {
                return null;
            }

            @Override
            public long getCurrent() {
                return 0;
            }

            @Override
            public IPage<Map<String, Object>> setCurrent(long current) {
                return null;
            }
        });
    }

    @Override
    public ResultEntity getNeedById(Integer needId) {
        Map<String, Object> tempMap = new HashMap<>();
        SweetNeedOrder byId = this.getById(needId);
        if (byId == null) return ResultEntity.error("需求不存在");
        tempMap.put("needOrder",byId);
        List<SweetNeedOrderClassify> classifyOid = orderClassifyService.list(
                new QueryWrapper<SweetNeedOrderClassify>()
                        .eq("need_order_classify_oid", byId.getNeedId()));
        classifyOid.forEach(v1->{
            SweetNeedClassify classify = needClassifyService.getById(v1.getNeedOrderClassifyCid());
            v1.setNeedOrderClassifyName(classify.getServerClassifyName());
        });
        tempMap.put("needClassifyList", classifyOid);
        return ResultEntity.succeed(tempMap);
    }

    @Override
    public ResultEntity getNeedByUserId(PageEntity pageEntity, Long userId) {

        Page<SweetNeedOrder> page = this.page(new Page<>(pageEntity.getPage(), pageEntity.getLimit()),
                new QueryWrapper<>(new SweetNeedOrder()).eq("need_uid", userId));
        ArrayList<Map<String, Object>> resultList = new ArrayList<>();
        List<SweetNeedOrder> records = page.getRecords();
        records.forEach(v->{
            try {
                Map<String, Object> tempMap = new HashMap<>();
                tempMap.put("needOrder",v);
                List<SweetNeedOrderClassify> classifyOid = orderClassifyService.list(
                        new QueryWrapper<SweetNeedOrderClassify>().eq("need_order_classify_oid", v.getNeedId()));
                classifyOid.forEach(v1->{
                    SweetNeedClassify classify = needClassifyService.getById(v1.getNeedOrderClassifyCid());
                    v1.setNeedOrderClassifyName(classify.getServerClassifyName());
                });
                tempMap.put("needClassifyList", classifyOid);
                resultList.add(tempMap);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        return ResultEntity.succeed(new IPage<Map<String, Object>>() {
            @Override
            public List<OrderItem> orders() {
                return page.orders();
            }

            @Override
            public List<Map<String, Object>> getRecords() {
                return resultList;
            }

            @Override
            public IPage<Map<String, Object>> setRecords(List<Map<String, Object>> records) {
                return null;
            }

            @Override
            public long getTotal() {
                return page.getTotal();
            }

            @Override
            public IPage<Map<String, Object>> setTotal(long total) {
                return null;
            }

            @Override
            public long getSize() {
                return page.getSize();
            }

            @Override
            public IPage<Map<String, Object>> setSize(long size) {
                return null;
            }

            @Override
            public long getCurrent() {
                return 0;
            }

            @Override
            public IPage<Map<String, Object>> setCurrent(long current) {
                return null;
            }
        });
    }

    @Override
    public ResultEntity addNeed(SweetNeedOrder needOrder, List<Integer> classifyIds) {
        if (needOrder.getNeedUid() == null) return ResultEntity.error("用户id不能为空");
        if (needOrder.getNeedAppointStartTime() == null || needOrder.getNeedAppointEndTime() == null) return ResultEntity.error("请选择预约时间");
        if (needOrder.getNeedWorkplace() == null)return ResultEntity.error("请选择工作地点");
        needOrder.setNeedDeposit(BigDecimal.valueOf(100));
        needOrder.setNeedCreateTime(LocalDateTime.now());
        needOrder.setNeedUserState(0);
        needOrder.setNeedUserIsDel(false);
        needOrder.setNeedWorkerIsDel(false);
        return ResultEntity.isValid(this.save(needOrder),"添加成功","添加失败");
    }

    @Override
    public ResultEntity changeNeed(SweetNeedOrder needOrder, Long userId) {
        if (needOrder.getNeedUid() == null) return ResultEntity.error("用户id不能为空");
        if (needOrder.getNeedId() == null) return ResultEntity.error("需求id不能为空");
        SweetNeedOrder needOrderInfo = this.getById(needOrder.getNeedId());
        if (needOrderInfo == null) return ResultEntity.error("需求不存在");
        if (!needOrderInfo.getNeedUid().equals(userId)) return ResultEntity.error("需求不属于该用户");
        return ResultEntity.isValid(this.save(needOrderInfo),"修改成功","修改失败");
    }

    @Override
    public ResultEntity deleteNeed(SweetNeedOrder needOrder, Long userId) {
        if (needOrder.getNeedUid() == null) return ResultEntity.error("用户id不能为空");
        if (needOrder.getNeedId() == null) return ResultEntity.error("需求id不能为空");
        SweetNeedOrder needOrderInfo = this.getById(needOrder.getNeedId());
        if (needOrderInfo == null) return ResultEntity.error("需求不存在");
        needOrderInfo.setNeedUserIsDel(true);
        if (!needOrderInfo.getNeedUid().equals(userId)) return ResultEntity.error("需求不属于该用户");
        return ResultEntity.isValid(this.save(needOrderInfo),"删除成功","删除失败");
    }
}
