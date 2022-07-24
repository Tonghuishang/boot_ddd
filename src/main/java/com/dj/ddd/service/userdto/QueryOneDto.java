package com.dj.ddd.service.userdto;

import lombok.Data;

@Data
public class QueryOneDto {
    private Integer id;
    private Integer userId;
    private String userName;
    private String sexShow;
    private Integer age;
    private String nickName;
}
