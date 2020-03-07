package com.health.dao;

import com.health.pojo.Food;

public interface FoodMapper {
    int insert(Food record);

    int insertSelective(Food record);
}