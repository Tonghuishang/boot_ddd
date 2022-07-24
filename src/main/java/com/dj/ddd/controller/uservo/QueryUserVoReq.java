package com.dj.ddd.controller.uservo;

import lombok.Data;
import sun.util.resources.LocaleData;

@Data
public class QueryUserVoReq {

    private String userName;
    private Integer sex;
    private Integer startAge;
    private Integer endAge;
    private Integer pageNo;
    private String startTime;
    private String endTime;
}
