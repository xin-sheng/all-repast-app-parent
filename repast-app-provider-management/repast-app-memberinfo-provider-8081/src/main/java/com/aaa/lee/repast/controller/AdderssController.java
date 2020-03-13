package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.CommonController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.MemberReceiveAddress;
import com.aaa.lee.repast.service.AdderssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class AdderssController extends CommonController {

    @Autowired
    private AdderssService adderssService;

    @Override
    public BaseService getBaseService() {
        return adderssService;
    }

    /**
     *  根据用户id查询数据的所有收货地址
     * @param id
     * @return
     */
    @RequestMapping("/adderss")
    public ResultData SelectAllAdderss(Long memberId){
        List list = getBaseService().queryList(memberId);
        if(list.size() > 0){
            return super.operationSuccess(list);
        }else {
            return super.operationFailed();
        }
    }

    /**
     * 新增收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/addAdders")
    public ResultData AddAdderss(MemberReceiveAddress memberReceiveAddress){
        Integer add = getBaseService().add(memberReceiveAddress);
        if(add > 0){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * 修改收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/updateAdders")
    public ResultData updateAdders(MemberReceiveAddress memberReceiveAddress){
        Integer update = getBaseService().update(memberReceiveAddress);
        if(update > 0){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

    /**
     * 根据收货地址id删除
     * @param id
     * @return
     */
    @GetMapping("/delAdders/{id}")
    public ResultData delAdders(@PathVariable("id")Long id){
        Integer delete = getBaseService().delete(id);
        if(delete > 0){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }

}
