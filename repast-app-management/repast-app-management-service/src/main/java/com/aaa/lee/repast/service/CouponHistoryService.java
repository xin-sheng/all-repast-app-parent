package com.aaa.lee.repast.service;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.mapper.CouponHistoryMapper;
import com.aaa.lee.repast.mapper.CouponMapper;
import com.aaa.lee.repast.model.Coupon;
import com.aaa.lee.repast.model.CouponHistory;
import com.aaa.lee.repast.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @autor:
 * @date: 2020-03-13
 * @Description:
 */
@Service
public class CouponHistoryService extends BaseService<CouponHistory> {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private CouponHistoryMapper couponHistoryMapper;

    public Boolean getCoupon(Coupon coupon, Long memberId,String nickName ){

        Coupon coupon1 = couponMapper.selectByPrimaryKey(coupon.getId());
        if (coupon1.getCount()!=null&&coupon1.getCount()!=0){
            CouponHistory couponHistory = new CouponHistory();
            couponHistory.setShopId(coupon.getShopId())
                    .setMemberId(memberId)
                    .setCouponId(coupon.getId())
                    .setCouponCode(coupon.getCode())
                    .setMemberNickname(nickName)
                    .setGetType(1);
            int insert = couponHistoryMapper.insert(couponHistory);
            if (insert!=0){
                Coupon coupon2 = coupon1.setCount(coupon1.getCount() - 1);
                couponMapper.updateByPrimaryKey(coupon2);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
}
