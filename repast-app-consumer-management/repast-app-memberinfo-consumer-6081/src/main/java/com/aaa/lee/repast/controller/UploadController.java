package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("/upload")
@Api
public class UploadController extends BaseController {

    @Autowired
    private IRepastService repastService;

    @ApiOperation(value = "文件上传",notes = "执行用户头像上传操作")
    @PostMapping("/upload")
    public Boolean uploadFile(MultipartFile file,String token){
        return repastService.uploadFile(file, token);
    }

}
