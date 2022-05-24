package top.dragon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import top.dragon.entity.ResultEntity;
import top.dragon.entity.SweetUser;
import top.dragon.feign.MerchantService;
import top.dragon.feign.WorkerService;
import top.dragon.job.ResultUserInfo;
import top.dragon.mapper.SweetUserMapper;
import top.dragon.feign.AliSmsService;
import top.dragon.service.SweetUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.dragon.utils.EncodeUtils;
import top.dragon.utils.JwtUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-13
 */
@Service
public class SweetUserServiceImpl extends ServiceImpl<SweetUserMapper, SweetUser> implements SweetUserService {

    @Resource
    private JwtUtils jwtUtils;

    @Resource
    private AliSmsService smsService;

    @Resource
    private MerchantService merchantService;

    @Resource
    private WorkerService workerService;

    @Override
    public ResultEntity login(String phone, String password, HttpServletResponse response) {
        if (StringUtils.isAnyBlank(phone, password)) return ResultEntity.error("手机号或密码不能为空");
        if (phone.length() != 11) return ResultEntity.error("手机号格式不正确");
        SweetUser userInfo = this.getOne(new QueryWrapper<SweetUser>()
                .eq("user_phone", phone).eq("user_is_del", false));
        if (userInfo == null) return ResultEntity.error("账号或密码错误");
        if (!userInfo.getUserPassword().equals(EncodeUtils.shaEncode(password))) return ResultEntity.error("账号或密码错误");
        String token = jwtUtils.createJwtToken(259200000L, userInfo.getUserId());
        userInfo.setUserToken(token);
        userInfo.setUserIsShop(merchantService.isExistByUserId(userInfo.getUserId()).getBody());
        userInfo.setUserIsWorker(workerService.isExistByUserId(userInfo.getUserId()).getBody());
        response.setHeader("Authorization", token);
        return ResultEntity.succeed(new ResultUserInfo(userInfo));
    }

    @Override
    public ResultEntity logout() {
        return null;
    }

    @Override
    public ResultEntity register(String phone, String password, String code) {
        if (StringUtils.isAnyBlank(phone, password, code)) return ResultEntity.error("手机号或密码或验证码不能为空");
        if (phone.length() != 11) return ResultEntity.error("手机号格式不正确");
        SweetUser user = this.getOne(new QueryWrapper<SweetUser>().eq("user_phone", phone)
                .eq("user_is_del", false));
        if (user != null) return ResultEntity.error("该手机号已被注册");
        SweetUser sweetUser = new SweetUser();
        sweetUser.setUserPassword(EncodeUtils.shaEncode(password));
        sweetUser.setUserPhone(phone);
        sweetUser.setUserIsDel(false);
        sweetUser.setUserName(phone);
        sweetUser.setUserStatus(0);
        sweetUser.setUserBalance(BigDecimal.ZERO);
        return ResultEntity.isValid(this.save(sweetUser)
                ,"注册成功","注册失败",
                new ResultUserInfo(sweetUser));
    }
    @Override
    public ResultEntity resetPassword(String phone, String password, String code) {
        if (StringUtils.isAnyBlank(phone, password, code)) return ResultEntity.error("手机号或密码或验证码不能为空");
        if (phone.length() != 11) return ResultEntity.error("手机号格式不正确");
        SweetUser user = this.getOne(new QueryWrapper<SweetUser>().eq("phone", phone)
                .eq("user_is_del", false));
        if (user == null) return ResultEntity.error("该手机号未注册");
        return ResultEntity.isValid(this.updateById(
                new SweetUser().setUserPassword(EncodeUtils.shaEncode(password))));
    }

    @Override
    public ResultEntity sendCode(String phone) {
        if (StringUtils.isAnyBlank(phone)) return ResultEntity.error("手机号不能为空");
        if (phone.length() != 11) return ResultEntity.error("手机号格式不正确");
        return ResultEntity.isValid(smsService.sendSms(phone));
    }

    @Override
    public ResultEntity updatePassword(String oldPassword, String newPassword, Long userId) {
        if (StringUtils.isAnyBlank(oldPassword, newPassword)) {
            return ResultEntity.error("旧密码或新密码不能为空");
        }
        SweetUser user = this.getById(userId);
        if (user == null) return ResultEntity.error("修改失败");
        if (!user.getUserPassword().equals(EncodeUtils.shaEncode(oldPassword))) {
            return ResultEntity.error("旧密码错误");
        }
        user.setUserPassword(EncodeUtils.shaEncode(newPassword));
        return ResultEntity.isValid(this.updateById(user), "修改成功", "修改失败");
    }

    @Override
    public ResultEntity updatePhone(String phone, String newPhone, String code, Long userId) {
        if (StringUtils.isAnyBlank(phone, code)) {
            return ResultEntity.error("手机号或验证码不能为空");
        }
        if (phone.length() != 11) return ResultEntity.error("手机号格式不正确");
        SweetUser user = this.getById(userId);
        if (user == null) return ResultEntity.error("修改失败");
        if (!smsService.verifySms(phone, code)) return ResultEntity.error("验证码错误");
        user.setUserPhone(newPhone);
        return ResultEntity.isValid(this.updateById(user), "修改成功", "修改失败");
    }

    @Override
    public ResultEntity updateAvatar(String avatar, Long userId) {
        if (StringUtils.isAnyBlank(avatar)) return ResultEntity.error("头像不能为空");
        SweetUser user = this.getById(userId);
        if (user == null) return ResultEntity.error("修改失败");
        user.setUserIcon(avatar);
        return ResultEntity.isValid(this.updateById(user), "修改成功", "修改失败");
    }

    @Override
    public ResultEntity realName(String realName, String idCard, Long userId) {
        if (StringUtils.isAnyBlank(realName, idCard)) return ResultEntity.error("真实姓名或身份证号不能为空");
        SweetUser user = this.getById(userId);
        if (user == null) return ResultEntity.error("修改失败");
        user.setUserIdentityName(realName);
        user.setUserIdentityId(idCard);
        return ResultEntity.isValid(this.updateById(user), "修改成功", "修改失败");
    }
}
