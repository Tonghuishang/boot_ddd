package com.dj.ddd.mapper.userbo;

import lombok.Data;
import sun.util.resources.LocaleData;

@Data
public class QueryUserBo {
    private String userName;
    private Integer sex;
    private Integer startAge;
    private Integer endAge;
    private Integer pageNo;
    private String loginTimeShow;
    private String startTime;
    private String endTime;
}
