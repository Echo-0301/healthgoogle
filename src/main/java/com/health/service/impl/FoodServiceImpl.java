package com.health.service.impl;

import com.health.common.ServerResponse;
import com.health.entity.Food;
import com.health.mapper.FoodMapper;
import com.health.service.IFoodService;
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
public class FoodServiceImpl implements IFoodService {

    @Autowired
    FoodMapper foodMapper;

    @Override
    public ServerResponse<List<Food>> showFood(int userId) {

        List<Food> foods = foodMapper.selectByUserId(userId);

        if(foods!=null){
            return new ServerResponse(200,"Success",foods);
        }

        return new ServerResponse<>(401,"Find the mistakes");

    }

    @Override
    public ServerResponse<Food> self(Food food) {

        int result;
        result = foodMapper.insert(food);
        if(result>0){
            return new ServerResponse(501,"fail");
        }
        return new ServerResponse(200,"Success");
    }

    @Override
    public int selectRepect(String name) {
        return foodMapper.selectRepect(name);
    }


}
