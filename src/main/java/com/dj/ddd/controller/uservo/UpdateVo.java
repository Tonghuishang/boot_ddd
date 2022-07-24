package com.dj.ddd.controller.uservo;

import lombok.Data;

@Data
public class UpdateVo {

    private Integer id;

    private Integer userId;

    private String userName;

    private String userPwd;

    private String sex;

    private Integer age;

    private String nickName;
}
