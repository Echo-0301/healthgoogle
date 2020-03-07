package com.health.dao;

import com.health.pojo.Diet;

public interface DietMapper {
    int insert(Diet record);

    int insertSelective(Diet record);
}