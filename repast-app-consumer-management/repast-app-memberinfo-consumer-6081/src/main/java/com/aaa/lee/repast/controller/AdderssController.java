package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.annotation.LoginLogAnnotation;
import com.aaa.lee.repast.base.BaseController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.MemberReceiveAddress;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/adderss")
@Api(value = "收货地址信息", tags = "收货地址接口(提供用户收货地址信息)")
public class AdderssController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 查询所有收货地址
     * @param memberId
     * @return
     */
    @GetMapping("/adderss")
    @ApiOperation(value = "查询所有收货地址", notes = "用户执行查询所有收货地址(查询所有收货地址)")
    public ResultData SelectAllAdderss(Long memberId){
         return repastService.SelectAllAdderss(memberId);
    }

    /**
     * 新增收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/addAdders")
    @ApiOperation(value = "增加收货地址", notes = "用户执行增加收货地址(增加收货地址)")
    public ResultData AddAdderss(MemberReceiveAddress memberReceiveAddress){
        return repastService.AddAdderss(memberReceiveAddress);
    }

    /**
     * 修改收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/updateAdders")
    @ApiOperation(value = "修改收货地址", notes = "用户执行修改收货地址(修改收货地址)")
    public ResultData updateAdders(MemberReceiveAddress memberReceiveAddress){
        return repastService.updateAdders(memberReceiveAddress);
    }

    /**
     * 根据收货地址id删除数据
     * @param id
     * @return
     */
    @GetMapping("/delAdders/{id}")
    @ApiOperation(value = "删除收货地址", notes = "用户执行删除收货地址(删除收货地址)")
    public ResultData delAdders(@PathVariable("id") Long id){
        return repastService.delAdders(id);
    }

}
