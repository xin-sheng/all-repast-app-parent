package com.aaa.lee.repast.service;

import com.aaa.lee.repast.base.BaseService;
import com.aaa.lee.repast.mapper.CouponHistoryMapper;
import com.aaa.lee.repast.mapper.CouponMapper;
import com.aaa.lee.repast.mapper.MemberMapper;
import com.aaa.lee.repast.model.Coupon;
import com.aaa.lee.repast.model.CouponHistory;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @autor:
 * @date: 2020-03-13
 * @Description:
 */
@Service
@EnableScheduling
public class CouponHistoryService extends BaseService<CouponHistory> {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private CouponHistoryMapper couponHistoryMapper;

    @Autowired
    private MemberMapper memberMapper;

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

    /**
     *这个方法每天凌晨1点检查优惠卷是否过期
     *      实现步骤
     *          1， 查询所有用户
     *          2， 在查询用户拥有的票
     *          3， for循环遍历每一个票是否过期
     *          4， new Date() 如果票的过期时间大于当前时间  那么修改票的状态为过期
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void timeVolume(){
        List<Member> members = memberMapper.selectAll();
        for (Member member : members) {
            @Size(max = 20) @NotNull Long memberId = member.getId();
            List<CouponHistory> couponHistories = couponHistoryMapper.selectByExample(memberId);
            for (CouponHistory couponHistory : couponHistories) {
                Long id = couponHistory.getCouponId();
                Coupon coupon = new Coupon();
                Coupon coupon1 = couponMapper.selectOne(coupon.setId(id));
                String dateNow = DateUtil.getDateNow();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parse = null;
                try {
                    parse = simpleDateFormat.parse(dateNow);
                } catch (ParseException e) {
                    e.printStackTrace();
                    Date date = new Date();
                }
                Date endTime = coupon1.getEndTime();
                if(parse.getTime() > endTime.getTime()){
                    Integer integer = couponHistoryMapper.xiuTwo(Integer.valueOf(coupon1.getId().toString()));

                }


            }
        }
    }

}
