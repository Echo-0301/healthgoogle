package com.health.service.impl;

import com.health.common.ServerResponse;
import com.health.entity.Record;
import com.health.mapper.RecordMapper;
import com.health.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@Service
public class RecordServiceImpl implements IRecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public ServerResponse add_record(Record record) {

        int result;
        result = recordMapper.insertByUserId(record);
        if(result<=0){
            return new ServerResponse(501,"fail");
        }
        return new ServerResponse(200,"Success");
    }
}
