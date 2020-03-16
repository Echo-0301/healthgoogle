package com.health.controller;


import com.health.common.ServerResponse;
import com.health.entity.Food;
import com.health.entity.Record;
import com.health.service.IRecordService;
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
@RequestMapping("/pojo/record")
public class RecordController {

    @Autowired
    IRecordService iRecordService;

    @PostMapping("/api/add_record")
    public ServerResponse add_record(Record record, @RequestParam int userId,HttpSession session){

        record.setUserId(userId);
//        return iRecordService.add_record(record);
        if(session.getAttribute("user")!=null){

            return iRecordService.add_record(record);
        }
        else{
            return new ServerResponse<List<Food>>(400,"Please login");
        }

    }
}
