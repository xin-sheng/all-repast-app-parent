package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseController;
import com.aaa.lee.repast.model.Coupon;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor:
 * @date: 2020-03-13
 * @Description:
 */
@RestController
@Api(value = "优惠卷", tags = "领取优惠卷接口")
public class CouponHistoryController extends BaseController {
    @Autowired
    private IRepastService repastService;


    @PostMapping("/getCoupon")
    @ApiOperation(value = "登录", notes = "用户执行登录操作(接收微信端传递数据)")
    public Boolean getCoupon(Coupon coupon,
                             @RequestParam("memberId") Long memberId,
                             @RequestParam("nickName") String nickName ){
      return repastService.getCoupon(coupon,memberId,nickName);
    }
}
