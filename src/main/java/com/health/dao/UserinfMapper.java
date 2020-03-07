package com.health.dao;

import com.health.pojo.Userinf;

public interface UserinfMapper {
    int insert(Userinf record);

    int insertSelective(Userinf record);
}