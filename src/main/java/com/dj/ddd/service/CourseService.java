package com.dj.ddd.service;

import com.dj.ddd.controller.coursevo.CourseResp;
import com.dj.ddd.mapper.entity.Course;
import com.dj.ddd.service.coursedto.CourseDto;
import com.dj.ddd.service.coursedto.TeacherDto;
import com.dj.ddd.service.coursedto.TraDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> findAll();

    List<TraDto> findTro(Integer id);

    List<TeacherDto> findTeacher(Integer id);

    void updateState(Integer id, Integer state);
}
