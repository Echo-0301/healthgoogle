package com.health.dao;

import com.health.pojo.Record;

public interface RecordMapper {
    int insert(Record record);

    int insertSelective(Record record);
}