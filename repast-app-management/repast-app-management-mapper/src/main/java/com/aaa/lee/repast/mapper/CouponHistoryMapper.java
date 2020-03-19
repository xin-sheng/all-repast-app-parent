package com.aaa.lee.repast.mapper;

import com.aaa.lee.repast.model.CouponHistory;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

public interface CouponHistoryMapper extends Mapper<CouponHistory> {

    Integer xiuTwo(Integer couponId);

}