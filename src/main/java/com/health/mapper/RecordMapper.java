package com.health.mapper;

import com.health.entity.Record;
import com.health.service.IFoodService;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface RecordMapper {

    public  int insertByUserId(Record record);
}
