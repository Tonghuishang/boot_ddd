package com.dj.ddd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.ddd.common.BusinessException;
import com.dj.ddd.common.DozerUtil;
import com.dj.ddd.mapper.UserMapper;
import com.dj.ddd.mapper.entity.UserDtoEntity;
import com.dj.ddd.mapper.entity.UserEntity;
import com.dj.ddd.mapper.entity.UserLoginRecord;
import com.dj.ddd.service.UserDetService;
import com.dj.ddd.service.UserLoginRecordService;
import com.dj.ddd.service.UserService;
import com.dj.ddd.service.userdto.AddDto;
import com.dj.ddd.service.userdto.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    private UserDetService userDetService;
    @Autowired
    private UserLoginRecordService userLoginRecordService;
    @Override
    public UserLoginDto login(UserLoginDto loginDto) throws BusinessException{
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",loginDto.getUserName());
        queryWrapper.eq("user_pwd",loginDto.getUserPwd());
        UserEntity user = super.getOne(queryWrapper);
        if(user ==null){
            throw  new BusinessException("账号或密码不正确");
        }
        UserLoginRecord userLoginRecord = new UserLoginRecord();
        userLoginRecord.setUserId(user.getId());
        LocalDateTime nowTime =  LocalDateTime.now();
        userLoginRecord.setLoginTime(nowTime);
        userLoginRecordService.addUserLoginRecord(userLoginRecord);
        return DozerUtil.map(user,UserLoginDto.class);
    }


    @Override
    public AddDto add(AddDto addDto) {
        UserEntity user = new UserEntity();
        user.setUserName(addDto.getUserName());
        user.setUserPwd(addDto.getUserPwd());
        super.save(user);
        UserDtoEntity userDtoEntity = new UserDtoEntity();
        userDtoEntity.setUserId(user.getId());
        userDtoEntity.setAge(addDto.getAge());
        userDtoEntity.setSex(addDto.getSex());
        userDtoEntity.setNickName(addDto.getNickName());
        userDetService.add(userDtoEntity);
        return null;
}

    @Override
    public void delete(Integer id, Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        super.remove(queryWrapper);
        userDetService.delete(id);
    }



    @Override
    public List<UserEntity> findAllTest() {
        return super.list();
    }

    @Override
    public UserEntity findByIdTest(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        return super.getOne(queryWrapper);
    }

    @Override
    public void addTest(UserEntity user) {
        super.save(user);
    }

    @Override
    public void deleteTest(Integer id) {
        super.removeById(id);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        super.updateById(userEntity);
    }


}
