package com.dj.ddd.service.userdto;

import lombok.Data;

@Data
public class UpdateDto {

    private Integer id;

    private Integer userId;

    private String userPwd;

    private String userName;

    private String sex;

    private Integer age;

    private String nickName;
}
