package top.dragon.service;

import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetUser;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-13
 */
public interface SweetUserService extends IService<SweetUser> {

    ResultEntity login(String phone, String password, HttpServletResponse response);

    ResultEntity logout();

    ResultEntity register(String phone, String password, String code);

    ResultEntity resetPassword(String phone, String password, String code);

    ResultEntity sendCode(String phone);

    ResultEntity updatePassword(String oldPassword, String newPassword, Long userId);

    ResultEntity updatePhone(String phone, String newPhone, String code, Long userId);

    ResultEntity updateAvatar(String avatar, Long userId);

    ResultEntity realName(String realName, String idCard, Long userId);


}
