package com.dj.ddd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.ddd.common.DozerUtil;
import com.dj.ddd.controller.coursevo.CourseResp;
import com.dj.ddd.controller.coursevo.CourseStuteReq;
import com.dj.ddd.mapper.CourseMapper;
import com.dj.ddd.mapper.coursebo.CourseBo;
import com.dj.ddd.mapper.coursebo.TeacherBo;
import com.dj.ddd.mapper.coursebo.TraBo;
import com.dj.ddd.mapper.entity.Course;
import com.dj.ddd.service.CourseService;
import com.dj.ddd.service.coursedto.CourseDto;
import com.dj.ddd.service.coursedto.TeacherDto;
import com.dj.ddd.service.coursedto.TraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public List<CourseDto> findAll() {
        List<CourseBo> courses = this.baseMapper.findAll();
        return DozerUtil.mapList(courses,CourseDto.class);
    }

    @Override
    public List<TraDto> findTro(Integer id) {
        List<TraBo> boList = this.baseMapper.findTro(id);
        return DozerUtil.mapList(boList,TraDto.class);
    }

    @Override
    public List<TeacherDto> findTeacher(Integer id) {
        List<TeacherBo> teacherBos = this.baseMapper.findTeacher(id);
        return DozerUtil.mapList(teacherBos,TeacherDto.class);
    }


    @Override
    public void updateState(Integer id, Integer state) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Course  course = super.getOne(queryWrapper);
        Integer sort2 = course.getSort();
        Course course1 = new Course();
        Course course2 = new Course();
        List<Course> updCourse = new ArrayList<>();
        if(state == 1){
            course1.setId(id);
            course1.setSort(course.getSort()-1);
            QueryWrapper queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("sort",sort2-1);
            Course  Course2 = super.getOne(queryWrapper2);
            course2.setId(Course2.getId());
            course2.setSort(Course2.getSort()+1);
            updCourse.add(course2);
            updCourse.add(course1);
        } else if(state == 2){
            course1.setId(id);
            course1.setSort(course.getSort()+1);

            QueryWrapper queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("sort",sort2+1);
            Course  Course2 = super.getOne(queryWrapper2);
            course2.setId(Course2.getId());
            course2.setSort(Course2.getSort()-1);
            updCourse.add(course2);
            updCourse.add(course1);
        } if(state == 3){
            course1.setId(id);
            course1.setSort(1);
            updCourse.add(course1);
            List<Course> listCourse = super.list();
            for (Course course3 : listCourse) {
                if(course3.getSort() < course.getSort()){
                    Course course4 = new Course();
                    course4.setId(course3.getId());
                    course4.setSort(course3.getSort()+1);
                    updCourse.add(course4);
                }
            }
        }if(state == 4){
            Integer maxSort = this.baseMapper.findMaxSort();
            QueryWrapper queryWrapper3 = new QueryWrapper<>();
            queryWrapper3.eq("sort",maxSort);
            Course  Course8 = super.getOne(queryWrapper3);
            course2.setId(Course8.getId());
            course2.setSort(Course8.getSort()-1);
            updCourse.add(course2);
            course1.setId(id);
            course1.setSort(maxSort);
            updCourse.add(course1);
            List<Course> listCourse = super.list();
            for (Course course3 : listCourse) {
                if(course3.getSort() > course.getSort()){
                    Course course5 = new Course();
                    course5.setId(course3.getId());
                    course5.setSort(course3.getSort()-1);
                    updCourse.add(course5);
                }
            }
        }
        super.updateBatchById(updCourse);

    }
}
