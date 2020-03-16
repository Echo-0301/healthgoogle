package com.health.mapper;

import com.health.entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */

public interface FoodMapper {

    public List<Food> selectByUserId(int userId);

    public  int insert(Food food);

    public int selectRepect(String name);

}
