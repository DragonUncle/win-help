package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.jsonwebtoken.lang.Collections;
import org.apache.commons.lang3.StringUtils;
import top.dragon.entity.ConditionQueryEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetNeedClassify;
import top.dragon.mapper.SweetNeedClassifyMapper;
import top.dragon.service.SweetNeedClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务分类 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-20
 */
@Service
public class SweetNeedClassifyServiceImpl extends ServiceImpl<SweetNeedClassifyMapper, SweetNeedClassify> implements SweetNeedClassifyService {

    @Override
    public ResultEntity getAllClassify(PageEntity pageEntity, ConditionQueryEntity conditionQueryEntity) {
        QueryWrapper<SweetNeedClassify> classifySql = new QueryWrapper<SweetNeedClassify>()
                .eq("server_classify_is_del", false)
                .eq("server_classify_is_show", true);
        List<String> likeNames = conditionQueryEntity.getLikeName();
        if(!Collections.isEmpty(likeNames))
            likeNames.forEach(name->{classifySql.like(name,conditionQueryEntity.getLikeValue());});
        Map<String, String> sortMap = conditionQueryEntity.getSortMap();
        if(!Collections.isEmpty(sortMap))
            sortMap.forEach((key,value)->{classifySql.orderBy(true,value.equals("asc"),key);});
        return ResultEntity.succeed(this.page(new Page<>(pageEntity.getPage(), pageEntity.getLimit()), classifySql));
    }

    @Override
    public ResultEntity getClassifyById(Integer classifyId) {
        return ResultEntity.succeed(this.getById(classifyId));
    }

    @Override
    public ResultEntity addClassify(SweetNeedClassify needClassify) {
        if(StringUtils.isBlank(needClassify.getServerClassifyName()))return ResultEntity.error("分类名称不能为空");
        needClassify.setServerClassifyIsDel(false);
        needClassify.setServerClassifyIsShow(false);
        needClassify.setServerClassifyCreateTime(LocalDateTime.now());
        return ResultEntity.isValid(this.save(needClassify),"添加成功","添加失败");
    }

    @Override
    public ResultEntity changeClassify(SweetNeedClassify needClassify) {
        if (needClassify.getServerClassifyId() == null) return ResultEntity.error("分类id不能为空");
        return ResultEntity.isValid(this.updateById(needClassify),"修改成功","修改失败");
    }

    @Override
    public ResultEntity deleteClassify(SweetNeedClassify needClassify) {
        if (needClassify.getServerClassifyId() == null) return ResultEntity.error("分类id不能为空");
        needClassify.setServerClassifyIsDel(true);
        return ResultEntity.isValid(this.updateById(needClassify),"删除成功","删除失败");
    }
}
