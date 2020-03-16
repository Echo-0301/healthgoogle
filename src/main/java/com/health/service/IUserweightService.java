package com.health.service;

import com.health.entity.Userweight;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface IUserweightService{

    List<Userweight> getAll(Integer id);

    List<Userweight> getOneMounth(Integer id);

    List<Userweight> getSevenDay(Integer id);

    double getMax(Integer id);

    double getMin(Integer id);

    double getAve(Integer id);

    double getToday(Integer id);

    double getYesterday(Integer id);
}
