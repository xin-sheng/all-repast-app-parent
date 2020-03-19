package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.CommonController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;


    @PostMapping("/upload")
    public Boolean uploadFile(MultipartFile file, String token){
        return uploadService.upload(file, token);
    }

}
