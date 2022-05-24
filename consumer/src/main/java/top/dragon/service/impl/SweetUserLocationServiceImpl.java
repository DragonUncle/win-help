package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import top.dragon.entity.PageEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetUserLocation;
import top.dragon.mapper.SweetUserLocationMapper;
import top.dragon.service.SweetUserLocationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户收货地址 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-19
 */
@Service
public class SweetUserLocationServiceImpl extends ServiceImpl<SweetUserLocationMapper, SweetUserLocation> implements SweetUserLocationService {

    @Override
    public ResultEntity getAll(PageEntity pageEntity, Long userId) {

        Page<SweetUserLocation> userLocationPage = this.page(
                new Page<>(pageEntity.getPage(), pageEntity.getLimit()),
                new QueryWrapper<SweetUserLocation>().eq("location_uid", userId)
                        .eq("location_is_del", false));
        return ResultEntity.succeed(userLocationPage);
    }

    @Override
    public ResultEntity add(SweetUserLocation sweetUserLocation, Long userId) {
        if (StringUtils.isAnyBlank(
                sweetUserLocation.getLocationName(),
                sweetUserLocation.getLocationTelephone(),
                sweetUserLocation.getLocationAddress(),
                sweetUserLocation.getLocationArea())) {
            return ResultEntity.error("参数不能为空");
        }
        sweetUserLocation.setLocationUid(userId);
        sweetUserLocation.setLocationIsDel(false);
        sweetUserLocation.setLocationCreateTime(LocalDateTime.now());
        return ResultEntity.isValid(this.save(sweetUserLocation), "添加成功", "添加失败");
    }



    @Override
    public ResultEntity change(SweetUserLocation sweetUserLocation, Long userId) {
        Long locationId = sweetUserLocation.getLocationId();
        if (locationId == null) return ResultEntity.error("参数不能为空");
        SweetUserLocation userLocation = this.getById(locationId);
        if (userLocation == null) return ResultEntity.error("收货地址不存在");
        if (userLocation.getLocationUid().equals(userId)) return ResultEntity.error("收货地址不属于当前用户");
        return ResultEntity.isValid(this.updateById(sweetUserLocation), "修改成功", "修改失败");
    }

    @Override
    public ResultEntity delete(SweetUserLocation sweetUserLocation, Long userId) {
        Long locationId = sweetUserLocation.getLocationId();
        if (locationId == null) return ResultEntity.error("参数不能为空");
        SweetUserLocation userLocation = this.getById(locationId);
        if (userLocation == null) return ResultEntity.error("收货地址不存在");
        if (userLocation.getLocationUid().equals(userId)) return ResultEntity.error("收货地址不属于当前用户");
        sweetUserLocation.setLocationIsDel(true);
        return ResultEntity.isValid(this.updateById(sweetUserLocation), "删除成功", "删除失败");
    }
}
