package com.dj.ddd.controller.uservo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
/**
 * 登录vo
 */
public class UserVoReq {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPwd;
}
