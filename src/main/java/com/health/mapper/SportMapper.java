package com.health.mapper;

import com.health.entity.Sport;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface SportMapper {

    public  int insert(Sport sport);

    public List<Sport> selectByUserId(int userId);

    public int selectRepect(String name);
}
