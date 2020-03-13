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

    @GetMapping("/integral/{token}")
    public ResultData integral(@PathVariable("token")String token){
        Member member = new Member();
        Member member1 = getBaseService().queryOne(member.setToken(token));
        if(null != member1){
            return super.operationSuccess(member1);
        }else {
            return super.operationFailed();
        }
    }

}
