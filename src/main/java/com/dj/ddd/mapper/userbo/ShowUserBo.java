package com.dj.ddd.mapper.userbo;

import lombok.Data;

@Data
public class ShowUserBo {
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer sex;
    private Integer age;
    private String sexShow;
    private String loginTimeShow;
    private String nickName;
}
