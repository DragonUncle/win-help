package top.dragon.service;

import org.springframework.http.ResponseEntity;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetUserLocation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户收货地址 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-19
 */
public interface SweetUserLocationService extends IService<SweetUserLocation> {

    ResultEntity getAll(PageEntity pageEntity, Long userId);

    ResultEntity add(SweetUserLocation sweetUserLocation, Long userId);

    ResultEntity change(SweetUserLocation sweetUserLocation, Long userId);

    ResultEntity delete(SweetUserLocation sweetUserLocation, Long userId);
}
