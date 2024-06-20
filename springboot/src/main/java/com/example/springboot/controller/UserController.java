package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.resp.Result;
import com.example.springboot.entity.UserEntity;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.req.LoginReq;
import com.example.springboot.req.UserReq;
import com.example.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Tag(name = "用户")
@RestController
@RequestMapping("/userEntity")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Validated LoginReq param, HttpSession session) {
        //账号是否存在
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("acc", param.getAcc());
        if (userMapper.selectCount(wrapper) == 0) {
            return Result.failure("账号不存在");
        }
        //密码是否正确
        if (!userService.getOne(wrapper).getPwd().equals(param.getPwd())) {
            return Result.failure("密码错误");
        }
        //验证码是否正确
        if (!(session.getAttribute("code").toString().equals(param.getCode()))) {
            return Result.failure("验证码错误");
        }
        //基本信息
        UserEntity user = userService.getOne(wrapper);
        //返回结果
        return Result.success(user);
    }

    @Operation(summary = "用户注册")
    @PostMapping("/regist")
    public Result regist(@RequestBody @Validated UserReq param) {
        param.setCreateTime(String.valueOf(new Date()));
        //账号存在性
        if (existUser(param)) {
            return Result.failure("账号已存在");
        }
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(param, user);
        if (userService.save(user)) {
            return Result.success("注册成功");
        }
        return Result.failure("注册失败，请稍后重试");
    }

    @Operation(summary = "用户修改信息")
    @PostMapping("/change")
    public Result change(@RequestBody @Validated UserReq param) {
        //账号存在性
        if (!existUser(param)) {
            return Result.failure("账号不存在");
        }
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("acc", param.getAcc());
        if (userService.update(wrapper)) {
            return Result.success("注册成功");
        }
        return Result.failure("注册失败，请稍后重试");
    }

    @Operation(summary = "账号是否存在")
    @PostMapping("/exist")
    public boolean existUser(@RequestBody @Validated UserReq param) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("acc", param.getAcc());
        if (userService.count(wrapper) == 0) {
            return false;
        }
        return true;
    }

    @Operation(summary = "根据账号查找")
    @PostMapping("/detail")
    public Result<UserEntity> detailUser(@RequestBody @Validated UserReq param) {
        //账号存在性
        if (!existUser(param)) {
            return Result.failure("用户不存在");
        }
        //查找
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("acc", param.getAcc());
        UserEntity userEntity = userService.getOne(wrapper);
        return Result.success(userEntity);
    }

    @Operation(summary = "用户列表")
    @GetMapping("/list")
    public Result<List<UserEntity>> listUser() {
        List<UserEntity> userEntityList = userService.list();
        return Result.success(userEntityList);
    }


}
