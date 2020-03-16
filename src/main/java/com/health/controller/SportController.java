package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.Sport;
import com.health.service.ISportService;
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
@RequestMapping("/pojo/sport")
public class SportController {

    @Autowired
    private ISportService iSportService;

    @PostMapping("/show")
    public ServerResponse<List<Sport>> showFood(@RequestParam int userId, HttpSession session){

        return iSportService.showSport(userId);
//        if(session.getAttribute("user")!=null){
//
//            return iSportService.showSport(userId);
//        }
//        else{
//            return new ServerResponse<List<Sport>>(400,"Please login");
//        }
    }
}
