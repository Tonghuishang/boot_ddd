package com.dj.ddd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.ddd.mapper.UserLoginRecordMapper;
import com.dj.ddd.mapper.entity.UserLoginRecord;
import com.dj.ddd.service.UserLoginRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord>
        implements UserLoginRecordService {


    @Override
    public void addUserLoginRecord( UserLoginRecord userLoginRecord) {
        super.save(userLoginRecord);
    }
}
