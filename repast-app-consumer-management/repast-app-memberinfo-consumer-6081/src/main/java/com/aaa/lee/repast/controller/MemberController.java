package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.annotation.*;
import com.aaa.lee.repast.base.BaseController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:13
 * @Description
 **/
@RestController("/user")
@Api(value = "用户信息", tags = "用户信息接口(提供用户所欲有关操作)")
public class MemberController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     *      member这个参数是由微信过来的--->并不知道自己数据库中的member_id是多少
     *      只会传递open_id
     * @param [member]
     * @date 2020/3/10
     * @return com.aaa.lee.repast.base.ResultData
     * @throws
    **/
    @PostMapping("/doLogin")
    @ApiOperation(value = "登录", notes = "用户执行登录操作(接收微信端传递数据)")
    @LoginLogAnnotation(operationType = "登录操作", operationName = "普通用户登录")
    public ResultData doLogin(Member member) {
        // 需要调用api工程(feign)
        Boolean ifSuccess = repastService.doLogin(member);
        if(ifSuccess) {
            return super.loginSuccess();
        }
        return super.loginFailed();
    }

    @GetMapping("/integral/{openId}")
    @ApiOperation(value = "积分", notes = "用户执行积分查询操作(根据openId查询用户的积分)")
    public ResultData integral(@PathVariable("openId") String openId){
        return repastService.integral(openId);
    }

    @ApiOperation(value = "查询个人信息",notes = "用户执行查询自己当前积分的操作(根据用户的id来查询)")
    @GetMapping("/personal")
    public ResultData personal(@PathVariable("openId") String openId){
        return repastService.personal(openId);
    }

    /**
     * 根据用户id修改个人信息
     * @param member
     * @return
     */
    @ApiOperation(value = "修改个人信息",notes = "用户执行对个人信息的修改(根据用户id修改个人信息)")
    @PostMapping("/personalUpdate")
    public ResultData personalUpdate(Member member){
        return repastService.personalUpdate(member);
    }


}
