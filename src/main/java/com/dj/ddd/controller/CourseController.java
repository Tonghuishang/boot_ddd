package com.dj.ddd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.ddd.common.DozerUtil;
import com.dj.ddd.common.ResultModel;
import com.dj.ddd.controller.coursevo.CourseResp;
import com.dj.ddd.controller.coursevo.CourseStuteReq;
import com.dj.ddd.mapper.entity.Course;
import com.dj.ddd.service.CourseService;
import com.dj.ddd.service.coursedto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/c/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("show")
    public ResultModel show(){
            List<CourseDto> courseList = courseService.findAll();
        return new ResultModel<>().success(DozerUtil.mapList(courseList, CourseResp.class));
    }
    @RequestMapping("orderBy")
    public ResultModel orderBy(Integer id, Integer state){
        courseService.updateState(id,state);
        return new ResultModel<>().success();
    }
}
