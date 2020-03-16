package com.health.service;

import com.health.common.ServerResponse;
import com.qiniu.common.QiniuException;

import java.io.File;
import java.util.Map;

public interface SelfService {
    public String uploadFile(File file) throws QiniuException;

    public ServerResponse add_self(Object object,String type);
}
