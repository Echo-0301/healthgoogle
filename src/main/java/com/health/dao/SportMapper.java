package com.health.dao;

import com.health.pojo.Sport;

public interface SportMapper {
    int insert(Sport record);

    int insertSelective(Sport record);
}