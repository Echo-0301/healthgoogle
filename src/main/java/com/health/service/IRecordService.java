package com.health.service;

import com.health.common.ServerResponse;
import com.health.entity.Record;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface IRecordService{

    public ServerResponse add_record(Record record);

}
