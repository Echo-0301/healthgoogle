package com.health.dao;

import com.health.pojo.Userweight;

public interface UserweightMapper {
    int insert(Userweight record);

    int insertSelective(Userweight record);
}