package com.dj.ddd.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user_login_record")
public class UserLoginRecord {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private LocalDateTime loginTime;

}
