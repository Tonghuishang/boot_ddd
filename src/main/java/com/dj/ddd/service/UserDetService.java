package com.dj.ddd.service;

import com.dj.ddd.common.PageResult;
import com.dj.ddd.mapper.entity.UserDtoEntity;
import com.dj.ddd.service.userdto.QueryOneDto;
import com.dj.ddd.service.userdto.QueryUserDto;
import com.dj.ddd.service.userdto.UpdateDto;

public interface UserDetService {
    void add(UserDtoEntity userDtoEntity);


    void delete(Integer id);

    PageResult findAll(QueryUserDto map);

    QueryOneDto findById(Integer id);

    void update(UpdateDto map);
}
