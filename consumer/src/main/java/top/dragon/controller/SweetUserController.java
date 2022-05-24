package top.dragon.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import top.dragon.entity.ResultEntity;
import top.dragon.entity.UserQueryEntity;
import top.dragon.service.SweetUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author DragonUncle
 * @since 2022-04-13
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class SweetUserController {
    @Resource
    private SweetUserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseEntity<ResultEntity> login(@RequestBody UserQueryEntity userQueryEntity,HttpServletResponse response){
        return ResponseEntity.ok(userService.login(userQueryEntity.getPhone(),userQueryEntity.getPassword(),response));
    }

    @GetMapping("/logout")
    public ResponseEntity<ResultEntity> logout(HttpServletRequest request){
        //Integer userId = Integer.parseInt(request.getHeader("userId"));

        return ResponseEntity.ok(ResultEntity.succeed());
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册")
    public ResponseEntity<ResultEntity> register(@RequestBody UserQueryEntity userQueryEntity){
        return ResponseEntity.ok(userService.register(userQueryEntity.getPhone(),
                userQueryEntity.getPassword(),userQueryEntity.getCode()));
    }

    @PostMapping("resetPassword")
    @ApiOperation(value = "重置密码")
    public ResponseEntity<ResultEntity> resetPassword(@RequestBody UserQueryEntity userQueryEntity){
        return ResponseEntity.ok(userService.resetPassword(userQueryEntity.getPhone(),
                userQueryEntity.getPassword(),userQueryEntity.getCode()));
    }

    @PostMapping("/sendCode")
    @ApiOperation(value = "发送验证码")
    public ResponseEntity<ResultEntity> sendCode(@RequestBody UserQueryEntity userQueryEntity){
        return ResponseEntity.ok(userService.sendCode(userQueryEntity.getPhone()));
    }

    @PostMapping("realName")
    @ApiOperation(value = "实名认证")
    public ResponseEntity<ResultEntity> realName(@RequestBody UserQueryEntity userQueryEntity,HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(userService.realName(userQueryEntity.getRealName(),userQueryEntity.getIdCard(),userId));
    }

    @PostMapping("/updatePassword")
    @ApiOperation(value = "修改密码")
    public ResponseEntity<ResultEntity> updatePassword(@RequestBody UserQueryEntity userQueryEntity,HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(userService.updatePassword(userQueryEntity.getOldPassword(),userQueryEntity.getNewPassword(),userId));
    }

    @PostMapping("/updatePhone")
    @ApiOperation(value = "修改手机号")
    public ResponseEntity<ResultEntity> updatePhone(@RequestBody UserQueryEntity userQueryEntity, HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(userService.updatePhone(userQueryEntity.getPhone(),userQueryEntity.getNewPassword(),userQueryEntity.getCode(),userId));
    }

    @PostMapping("/updateAvatar")
    @ApiOperation(value = "修改头像")
    public ResponseEntity<ResultEntity> updateAvatar(
            @ApiParam(value = "头像地址") @RequestBody String avatar,HttpServletRequest request){
        Long userId = Long.parseLong(request.getHeader("userId"));
        return ResponseEntity.ok(userService.updateAvatar(avatar,userId));
    }
}

