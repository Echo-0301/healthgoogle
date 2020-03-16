package com.health.service.impl;

import com.health.common.ServerResponse;
import com.health.entity.Sport;
import com.health.mapper.SportMapper;
import com.health.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@Service
public class SportServiceImpl implements ISportService {

    @Autowired
    SportMapper sportMapper;


    @Override
    public ServerResponse<List<Sport>> showSport(int userId) {

        List<Sport> sports = sportMapper.selectByUserId(userId);

        if(sports!=null){
            return new ServerResponse(200,"Success",sports);
        }

        return new ServerResponse<>(401,"Find the mistakes");

    }

    @Override
    public int selectRepect(String name) {
        return sportMapper.selectRepect(name);
    }

}
