package top.dragon.service;

import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetUserAttention;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户关注 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-13
 */
public interface SweetUserAttentionService extends IService<SweetUserAttention> {

    ResultEntity getList(PageEntity pageEntity);
}
