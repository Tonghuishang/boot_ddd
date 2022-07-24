package com.dj.ddd.service.userdto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserLoginDto {

    private Integer id;
    private Integer userId;
    private String userName;
    private String userPwd;
    private Integer sex;
    private Integer age;
    private String nickName;

}
