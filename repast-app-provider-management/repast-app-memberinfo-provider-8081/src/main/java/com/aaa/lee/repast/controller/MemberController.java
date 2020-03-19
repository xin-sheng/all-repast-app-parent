package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.CommonController;
import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.LoginLog;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.service.LoginLogService;
import com.aaa.lee.repast.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:53
 * @Description
 **/
@RestController
public class MemberController extends CommonController<Member> {

    @Autowired
    private MemberService memberService;

    @Override
    public BaseService<Member> getBaseService() {
        return memberService;
    }

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param [member]
     * @date 2020/3/10
     * @return java.lang.Boolean
     * @throws 
    **/
    @PostMapping("/doLogin")
    public Boolean doLogin(@RequestBody Member member) {
        return memberService.doLogin(member);
    }


    /**
     * 根据用户id查询用户当前积分操作
     * @param openId
     * @return
     */
    @GetMapping("/integral/{openId}")
    public ResultData integral(@PathVariable("openId")String openId){
        Member member = getBaseService().queryOne(new Member().setOpenId(openId));
        if(null != member){
            return super.operationSuccess(member);
        }else {
            return super.operationFailed();
        }
    }

    /**
     * 根据openid查询用户信息
     * @param openId
     * @return
     */
    @GetMapping("/personal")
    public ResultData personal(@PathVariable("openId") String openId){
        Member member = getBaseService().queryOne(new Member().setOpenId(openId));
        if(null != member){
            return super.operationSuccess(member);
        }else {
            return super.operationFailed();
        }
    }

    /**
     * 根据用户id修改个人信息
     * @param member
     * @return
     */
    @PostMapping("/personalUpdate")
    public ResultData personalUpdate(Member member){
        Integer update = getBaseService().update(member);
        if(update > 0){
            return super.operationSuccess();
        }else {
            return super.operationFailed();
        }
    }


}
