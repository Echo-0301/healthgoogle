package com.health.service;

import com.health.common.ServerResponse;
import com.health.entity.Food;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface IFoodService {

    public ServerResponse<List<Food>> showFood(int userId);

    public ServerResponse<Food> self(Food food);

    public int selectRepect(String name);
}
