package com.dj.ddd.service.userdto;

import lombok.Data;

@Data
public class AddDto {

    private String userName;
    private String userPwd;
    private Integer sex;
    private Integer age;
    private String nickName;
}
