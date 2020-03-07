package com.health.dao;

import com.health.pojo.UserWithBLOBs;

public interface UserMapper {
    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);
}