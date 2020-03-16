package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.Food;
import com.health.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@RestController
@RequestMapping("/pojo/food")
public class FoodController {

    @Autowired
    private IFoodService iFoodService;

    @PostMapping("/show")
    public ServerResponse<List<Food>> showFood(@RequestParam int userId, HttpSession session){

//        return iFoodService.showFood(userId);
        if(session.getAttribute("user")!=null){

            return iFoodService.showFood(userId);
        }
        else{
            return new ServerResponse<List<Food>>(400,"Please login");
        }
    }


}
