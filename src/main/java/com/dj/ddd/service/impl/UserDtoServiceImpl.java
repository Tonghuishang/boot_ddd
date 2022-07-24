package com.dj.ddd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.ddd.common.DozerUtil;
import com.dj.ddd.common.PageResult;
import com.dj.ddd.mapper.UserDetMapper;
import com.dj.ddd.mapper.userbo.QueryOneBo;
import com.dj.ddd.mapper.userbo.QueryUserBo;
import com.dj.ddd.mapper.userbo.ShowUserBo;
import com.dj.ddd.mapper.entity.UserDtoEntity;
import com.dj.ddd.mapper.entity.UserEntity;
import com.dj.ddd.service.UserDetService;
import com.dj.ddd.service.UserService;
import com.dj.ddd.service.userdto.QueryOneDto;
import com.dj.ddd.service.userdto.QueryUserDto;
import com.dj.ddd.service.userdto.UpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserDtoServiceImpl extends ServiceImpl<UserDetMapper, UserDtoEntity> implements UserDetService {

    @Autowired
    private UserService userService;

    @Override
    public void add(UserDtoEntity userDtoEntity) {
        super.save(userDtoEntity);
    }

    @Override
    public PageResult findAll(QueryUserDto queryUserDto) {
        IPage<ShowUserBo> page = new Page<>(queryUserDto.getPageNo(),2);
        IPage<ShowUserBo> pageInfo= super.getBaseMapper().findAll(page,DozerUtil.map(queryUserDto,QueryUserBo.class));
        return PageResult.pageInfo(pageInfo.getCurrent(),pageInfo.getPages(),
                DozerUtil.mapList(pageInfo.getRecords(),QueryUserDto.class));
    }

    @Override
    public QueryOneDto findById(Integer id) {
        QueryOneBo queryOneBo = this.baseMapper.findById(id);
        return DozerUtil.map(queryOneBo,QueryOneDto.class);
    }

    @Override
    public void update(UpdateDto map) {
        UserDtoEntity userDtoEntity = DozerUtil.map(map, UserDtoEntity.class);
        super.updateById(userDtoEntity);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(map.getUserId());
        userEntity.setUserName(map.getUserName());
        userEntity.setUserPwd(map.getUserPwd());
        userService.updateUser(userEntity);
    }

    @Override
    public void delete(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        super.remove(queryWrapper);
    }
}
