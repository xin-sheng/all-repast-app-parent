package com.aaa.lee.repast.controller;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.base.CommonController;
import com.aaa.lee.repast.model.Coupon;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.service.CouponHistoryService;
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
public class CouponHistoryController extends CommonController {
    @Autowired
    private CouponHistoryService couponHistoryService;
    public BaseService getBaseService() {
        return couponHistoryService;
    }

    @PostMapping("/getCoupon")
    public Boolean getCoupon(@RequestBody Coupon coupon,
                             @RequestParam("memberId") Long memberId,
                             @RequestParam("nickName") String nickName ){
        return couponHistoryService.getCoupon(coupon,memberId,nickName);
    }
}
