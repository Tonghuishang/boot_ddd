package com.dj.ddd.controller.coursevo;

import lombok.Data;

@Data
public class CourseStuteReq {
    private Integer id;
    private String courseName;
    private Integer sort;
    private Integer isDel;

}
