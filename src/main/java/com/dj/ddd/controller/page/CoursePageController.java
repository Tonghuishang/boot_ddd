package com.dj.ddd.controller.page;

import com.dj.ddd.common.DozerUtil;
import com.dj.ddd.controller.coursevo.TeacherResp;
import com.dj.ddd.controller.coursevo.TraResp;
import com.dj.ddd.service.CourseService;
import com.dj.ddd.service.coursedto.TeacherDto;
import com.dj.ddd.service.coursedto.TraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/c/")
public class CoursePageController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("toShow")
    public String toShow(){
        return "c/show";
    }

    @RequestMapping("toTraShow/{id}")
    public String toTraShow(@PathVariable Integer id, Model model){
        List<TraDto> traDto = courseService.findTro(id);
        model.addAttribute("tra", DozerUtil.mapList(traDto, TraResp.class));
        return "c/tra";
    }
    @RequestMapping("toTeacherShow/{id}")
    public String toTeacherShow(@PathVariable Integer id, Model model){
        List<TeacherDto> teacherDtos = courseService.findTeacher(id);
        model.addAttribute("tea", DozerUtil.mapList(teacherDtos, TeacherResp.class));
        return "c/tea";
    }

}
