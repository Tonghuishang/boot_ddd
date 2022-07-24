package com.dj.ddd.controller.uservo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class QueryUserResp {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String userName;

    private String sexShow;

    private Integer age;

    private String nickName;

    private String loginTimeShow;
}
