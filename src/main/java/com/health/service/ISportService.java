package com.health.service;

import com.health.common.ServerResponse;
import com.health.entity.Sport;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface ISportService {

    public ServerResponse<List<Sport>> showSport(int userId);

    public int selectRepect(String name);
}
