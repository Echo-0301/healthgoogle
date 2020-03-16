package com.health.service.impl;

import com.google.gson.Gson;
import com.health.common.ServerResponse;
import com.health.entity.Food;
import com.health.entity.Sport;
import com.health.mapper.FoodMapper;
import com.health.mapper.SportMapper;
import com.health.service.SelfService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
public class SelfServiceImpl implements SelfService {

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private Auth auth;

    @Autowired
    FoodMapper foodMapper;

    @Autowired
    SportMapper sportMapper;

    @Value("${qiniu.bucket}")
    private String bucket;

    private StringMap putPolicy;

    @Override
    public String uploadFile(File file) throws QiniuException {
//        String key = file.getName();
        String key = UUID.randomUUID().toString();
        Response response = this.uploadManager.put(file, key, getUploadToken());
        //解析上传的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

        String imageName = putRet.key;

        int retry = 0;
        while (response.needRetry() && retry < 3) {
            response = this.uploadManager.put(file, key, getUploadToken());
        }
        System.out.println(putRet.key+"   "+imageName);
        return imageName;
    }

    @Override
    public ServerResponse add_self(Object object,String type) {
        int result;
        if(type.equals("food")){

            result = foodMapper.insert((Food) object);
        }
        else{
            result = sportMapper.insert((Sport) object);
        }
        if(result<=0){
            return new ServerResponse(501,"fail");
        }
        return new ServerResponse(200,"Success");
    }

    private String getUploadToken() {
        return this.auth.uploadToken(bucket, null, 3600, putPolicy);
    }

}
