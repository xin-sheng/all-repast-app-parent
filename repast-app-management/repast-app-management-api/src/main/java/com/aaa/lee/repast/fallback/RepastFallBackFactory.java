package com.aaa.lee.repast.fallback;

import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.Coupon;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.model.MemberReceiveAddress;
import com.aaa.lee.repast.service.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:17
 * @Description
 **/
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {
            @Override
            public Boolean doLogin(Member member) {
                System.out.println("熔断登录方法！");
                return null;
            }

            @Override
            public ResultData saveLog(Map map) {
                System.out.println("熔断日志方法！");
                return null;
            }

            @Override
            public ResultData SelectAllAdderss(Long memberId) {
                System.out.println("熔断日志方法！");
                return null;
            }

            @Override
            public ResultData integral(@PathVariable("token")String token) {
                System.out.println("熔断日志方法！");
                return null;
            }



            @Override
            public ResultData AddAdderss(MemberReceiveAddress memberReceiveAddress) {
                System.out.println("熔断日志方法！");
                return null;
            }

            @Override
            public ResultData updateAdders(MemberReceiveAddress memberReceiveAddress) {
                System.out.println("熔断日志方法！");
                return null;
            }

            @Override
            public ResultData delAdders(Long id) {
                return null;
            }

            @Override
            public Boolean getCoupon(Coupon coupon, Long memberId, String nickName) {
                return null;
            }
        };
        return repastService;
    }

}
