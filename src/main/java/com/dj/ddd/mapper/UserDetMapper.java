package com.dj.ddd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dj.ddd.mapper.userbo.QueryOneBo;
import com.dj.ddd.mapper.userbo.QueryUserBo;
import com.dj.ddd.mapper.userbo.ShowUserBo;
import com.dj.ddd.mapper.entity.UserDtoEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDetMapper extends BaseMapper<UserDtoEntity>  {


    QueryOneBo findById(Integer id);

    IPage<ShowUserBo> findAll(IPage<ShowUserBo> page, @Param("bo") QueryUserBo bo);
}
