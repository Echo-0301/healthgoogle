package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.Userweight;
import com.health.service.IUserweightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@Controller
@RequestMapping("/pojo/userweight")
public class UserweightController {

    @Autowired
    private IUserweightService iUserweightService;


    @RequestMapping(value = "/getWeight",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getWeight(@RequestParam("id")Integer id,
                                    @RequestParam(value = "day",defaultValue = "0")Integer day){
        List<Userweight> userweightList = new ArrayList<>();
        if(day==0){//  全部
            userweightList = iUserweightService.getAll(id);
        }else if(day==7){
            userweightList = iUserweightService.getSevenDay(id);
        }else if(day==30){
            userweightList = iUserweightService.getOneMounth(id);
        }
//        double today ,yesterday;
//        today = iUserweightService.getToday(id);
//        yesterday=iUserweightService.getYesterday(id);

        double max,min,ave,wchange,dchange;
        Integer rday=day;
        max = iUserweightService.getMax(id);
        min = iUserweightService.getMin(id);
        ave = iUserweightService.getAve(id);
        wchange = max-min;
//        dchange=today-yesterday;
        for(Userweight i:userweightList){
            i.setMax(max);
            i.setMin(min);
            i.setAve(ave);
            i.setWchange(wchange);
//            i.setDchange(dchange);
            i.setRday(rday);
        }
        return new ServerResponse(200,"success",userweightList);
    }



}
