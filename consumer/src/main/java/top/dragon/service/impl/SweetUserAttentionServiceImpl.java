package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetUserAttention;
import top.dragon.mapper.SweetUserAttentionMapper;
import top.dragon.service.SweetUserAttentionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户关注 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-13
 */
@Service
public class SweetUserAttentionServiceImpl extends ServiceImpl<SweetUserAttentionMapper, SweetUserAttention> implements SweetUserAttentionService {

    @Override
    public ResultEntity getList(PageEntity pageEntity) {


        return ResultEntity.succeed();
    }
}
