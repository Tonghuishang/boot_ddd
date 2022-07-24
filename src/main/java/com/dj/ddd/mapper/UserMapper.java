package com.dj.ddd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dj.ddd.mapper.entity.UserEntity;

public interface UserMapper extends BaseMapper<UserEntity> {
    UserEntity findAll();
}
