package com.dj.ddd.controller;

import com.dj.ddd.common.DozerUtil;
import com.dj.ddd.common.PageResult;
import com.dj.ddd.common.ResultModel;
import com.dj.ddd.controller.uservo.*;
import com.dj.ddd.service.UserDetService;
import com.dj.ddd.service.UserService;
import com.dj.ddd.service.userdto.AddDto;
import com.dj.ddd.service.userdto.QueryUserDto;
import com.dj.ddd.service.userdto.UpdateDto;
import com.dj.ddd.service.userdto.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/u/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetService userDetService;

    @RequestMapping("login")
    public ResultModel login(UserVoReq userVoReq, HttpSession session){
        //参数校验
        Assert.hasText(userVoReq.getUserName(),"用户名不能为空");
        Assert.hasText(userVoReq.getUserPwd(),"密码不能为空");
        //实体类转实体类
        UserLoginDto loginDto = DozerUtil.map(userVoReq,UserLoginDto.class);
        //调用接口
        UserLoginDto dto = userService.login(loginDto);
        session.setAttribute("user",dto);
        return new ResultModel<>().success();
    }

    @RequestMapping("show")
    public ResultModel show(QueryUserVoReq queryUserVoReq){
        PageResult pageResult = userDetService.findAll(DozerUtil.map(queryUserVoReq,QueryUserDto.class));
        return new ResultModel<>().success(PageResult.pageInfo(pageResult.getCurrent(),pageResult.getPages(),
                DozerUtil.mapList(pageResult.getRecords(), QueryUserResp.class)));
    }

    @RequestMapping("add")
    public ResultModel add(AddVoPeq addVoPeq){
        Assert.hasText(addVoPeq.getUserName(),"用户名不能为空");
        Assert.hasText(addVoPeq.getUserPwd(),"密码不能为空");
        Assert.notNull(addVoPeq.getSex(),"性别不能为空");
        Assert.notNull(addVoPeq.getAge(),"年龄不能为空");
        Assert.hasText(addVoPeq.getNickName(),"昵称不能为空");
        AddDto addDto = DozerUtil.map(addVoPeq,AddDto.class);
        AddDto addDto1 = userService.add(addDto);
        return new ResultModel<>().success("注册成功");
    }
    @RequestMapping("delete1")
    public ResultModel delete1(Integer id, Integer userId){
        userService.delete(id, userId);
        return new ResultModel<>().success("成功");
    }
    @RequestMapping("update")
    public ResultModel update(UpdateVo updateVo){
        userDetService.update(DozerUtil.map(updateVo,UpdateDto.class));
        return new ResultModel<>().success("成功");
    }
    @RequestMapping("test")
    public ResultModel test(UpdateVo updateVo){
        userDetService.update(DozerUtil.map(updateVo,UpdateDto.class));
        return new ResultModel<>().success("成功");
    }
}
