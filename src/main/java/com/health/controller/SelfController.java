package com.health.controller;

import com.health.common.ServerResponse;
import com.health.entity.Food;
import com.health.entity.Sport;
import com.health.service.IFoodService;
import com.health.service.ISportService;
import com.health.service.SelfService;
import io.swagger.annotations.ApiOperation;
import javafx.scene.effect.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SelfController {

    @Value("${baseUploadUrl}")
    private String url;
    @Autowired
    SelfService selfService;
    @Autowired
    IFoodService foodService;
    @Autowired
    ISportService sportService;

    @PostMapping("api/add_self")
    public ServerResponse add_self(@RequestParam("id") int userId, @RequestParam("image") MultipartFile image,@RequestParam("name") String name,
                                   @RequestParam("col") double col,@RequestParam("tag") int tag,HttpSession session ) throws IOException {

//        if(session.getAttribute("user")==null){
//            return new ServerResponse<Food>(400,"Please login");
//        }
        if((tag==1 &&foodService.selectRepect(name)>0)||(tag==2 && sportService.selectRepect(name)>0))
        {
            return new ServerResponse(501,"repeat");
        }
        String result = this.uploadImg(image);
        System.out.println("result:"+result);
        if(result != null){
            if(tag == 1){
                Food food = new Food();
                food.setUserId(userId);
                food.setImage(result);
                food.setName(name);
                food.setCol(col);
                return selfService.add_self(food,"food");
            }
            else if(tag ==2){
                Sport sport = new Sport();
                sport.setUserId(userId);
                sport.setImage(result);
                sport.setName(name);
                sport.setCol(col);
                return selfService.add_self(sport,"sport");
            }

        }
        return new ServerResponse<Food>(400,"Failure on picture");

    }


    @ApiOperation(value = "单个图片上传到七牛云")
    public String uploadImg(MultipartFile upfile) throws IOException {
        String fileName = upfile.getOriginalFilename();
        File file = new File(url + fileName);
        try {
            //将MulitpartFile文件转化为file文件格式
            upfile.transferTo(file);
            return selfService.uploadFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
