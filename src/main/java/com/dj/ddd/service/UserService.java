package com.dj.ddd.service;

import com.dj.ddd.common.BusinessException;
import com.dj.ddd.mapper.entity.UserEntity;
import com.dj.ddd.service.userdto.AddDto;
import com.dj.ddd.service.userdto.UserLoginDto;

import java.util.List;

public interface UserService  {
    UserLoginDto login(UserLoginDto loginDto) throws BusinessException;

    AddDto add(AddDto addDto);

    void delete(Integer id, Integer userId);

    List<UserEntity> findAllTest();


    UserEntity findByIdTest(Integer id);

    void addTest(UserEntity user);

    void deleteTest(Integer id);

    void updateUser(UserEntity userEntity);
}
