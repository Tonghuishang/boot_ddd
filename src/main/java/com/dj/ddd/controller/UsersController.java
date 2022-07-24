package com.dj.ddd.controller;

import com.alibaba.fastjson.JSONObject;
import com.dj.ddd.common.HttpClientUtil;
import com.dj.ddd.common.ResultModel;
import com.dj.ddd.mapper.entity.UserEntity;
import com.dj.ddd.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("ajaxKy")
    public ResultModel lsit() throws Exception {
        String result = HttpClientUtil.sendHttpRequest("http://localhost:8081/ssm_03/user/show?i=1", HttpClientUtil.HttpRequestMethod.GET, new HashMap<>());
        //JSON 解析 将从B项目查询的json对象字符串 转换为 json对象
        final JSONObject obj = JSONObject.parseObject(result);
        System.out.println(obj.getJSONArray("data").getJSONObject(0).getInteger("id"));
        return new ResultModel().success(obj.getJSONArray("data"));
    }
    @GetMapping("/{id}")
    public UserEntity get(@PathVariable Integer id){
        return userService.findByIdTest(id);
    }

    @PostMapping
    public String put(UserEntity user){
        userService.addTest(user);
        return "成功";
    }
    @PutMapping
    public String update(UserEntity user){

        userService.updateUser(user);
        return "成功";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        userService.deleteTest(id);
        return "成功";
    }
    @DeleteMapping
    public String upload(@PathVariable Integer id){
        userService.deleteTest(id);
        return "成功";
    }

}
