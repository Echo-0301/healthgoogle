package com.health.service.impl;

import com.health.entity.Userweight;
import com.health.mapper.UserweightMapper;
import com.health.service.IUserweightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class UserweightServiceImpl implements IUserweightService {


    @Autowired
    private UserweightMapper userweightMapper;

    @Override
    public List<Userweight> getAll(Integer id) {

        return userweightMapper.getAll(id);
    }

    @Override
    public List<Userweight> getOneMounth(Integer id) {
        return userweightMapper.getOneMounth(id);
    }

    @Override
    public List<Userweight> getSevenDay(Integer id) {
        return userweightMapper.getSevenDay(id);
    }

    @Override
    public double getMax(Integer id) {
        return userweightMapper.getMax(id);
    }

    @Override
    public double getMin(Integer id) {
        return userweightMapper.getMin(id);
    }

    @Override
    public double getAve(Integer id) {
        return userweightMapper.getAve(id);
    }

    @Override
    public double getToday(Integer id) {

        return userweightMapper.getToday(id);
    }

    @Override
    public double getYesterday(Integer id) {

        return userweightMapper.getYesterday(id);
    }
}
