package com.dj.ddd.service.userdto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import sun.util.resources.LocaleData;

@Data
public class QueryUserDto {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer sex;
    private Integer startAge;
    private Integer endAge;
    private Integer pageNo;
    private String sexShow;
    private Integer age;
    private String nickName;
    private String loginTimeShow;
    private String startTime;
    private String endTime;
}
