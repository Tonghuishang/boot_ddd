package com.dj.ddd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dj.ddd.mapper.coursebo.CourseBo;
import com.dj.ddd.mapper.coursebo.TeacherBo;
import com.dj.ddd.mapper.coursebo.TraBo;
import com.dj.ddd.mapper.entity.Course;

import java.util.List;

public interface CourseMapper extends BaseMapper<Course> {
    List<CourseBo> findAll();

    List<TraBo> findTro(Integer id);

    List<TeacherBo> findTeacher(Integer id);

    Integer findMaxSort();
}
