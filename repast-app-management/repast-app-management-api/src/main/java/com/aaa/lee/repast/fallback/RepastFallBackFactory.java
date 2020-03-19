package com.aaa.lee.repast.fallback;

import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.model.Coupon;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.model.MemberReceiveAddress;
import com.aaa.lee.repast.service.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

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
                return null;
            }

            @Override
            public ResultData integral(String openId) {
                return null;
            }

            @Override
            public ResultData personal(String openId) {
                return null;
            }

            @Override
            public ResultData SelectAllAdders(Long memberId) {
                return null;
            }

            @Override
            public ResultData AddAdderss(MemberReceiveAddress memberReceiveAddress) {
                return null;
            }

            @Override
            public ResultData updateAdders(MemberReceiveAddress memberReceiveAddress) {
                return null;
            }

            @Override
            public ResultData delAdders(Long id) {
                return null;
            }

            @Override
            public ResultData deleteMany(String memberId, String deleteMany) {
                return null;
            }

            @Override
            public ResultData personalUpdate(Member member) {
                return null;
            }

            @Override
            public Boolean uploadFile(MultipartFile file, String token) {
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
