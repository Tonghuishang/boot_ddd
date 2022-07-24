package com.dj.ddd.mapper.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course_boot")
public class Course {
    private Integer id;
    private String courseName;
    private Integer sort;
    private Integer  isDel;

}
