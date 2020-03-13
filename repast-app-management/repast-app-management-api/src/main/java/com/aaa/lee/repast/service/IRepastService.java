package com.aaa.lee.repast.service;

import com.aaa.lee.repast.base.ResultData;
import com.aaa.lee.repast.fallback.RepastFallBackFactory;
import com.aaa.lee.repast.model.LoginLog;
import com.aaa.lee.repast.model.Member;
import com.aaa.lee.repast.model.MemberReceiveAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/10 10:16
 * @Description
 *      springcloud2.x之后，在feign中只能出现一次
 *      value的值非常重要:
 *          这个value的值，就取决于是否可以调用到provider中的值
 *              !!!! value的值指向的就是provider项目中application.properties文件中所配置的spring.application.name !!!!
 *              !!!! api中所写的接口，一定要和provider的Controller中的方法一模一样 !!!!
 **/
@FeignClient(value = "memberinfo-interface")
//@FeignClient(value = "memberinfo-interface", fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {

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
    Boolean doLogin(@RequestBody Member member);

    /**
     * @author Seven Lee
     * @description
     *      登录日志保存
     * @param [loginLog]
     * @date 2020/3/11
     * @return java.lang.Boolean
     * @throws
    **/
    @PostMapping("/add")
    ResultData saveLog(@RequestBody Map map);

    /**
     * 根据用户id查收货地址
     * @param id
     * @return
     */
    @RequestMapping("/adderss")
    ResultData SelectAllAdderss(Long memberId);

    /***
     * 根据token查询积分
     * @param token
     * @return
     */
    @GetMapping("/integral/{token}")
    ResultData integral(@PathVariable("token")String token);

    /**
     * 新增收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/addAdders")
    ResultData AddAdderss(MemberReceiveAddress memberReceiveAddress);

    /**
     *修改收货地址
     * @param memberReceiveAddress
     * @return
     */
    @PostMapping("/updateAdders")
    public ResultData updateAdders(MemberReceiveAddress memberReceiveAddress);

    /**
     * 根据收货地址id删除
     * @param id
     * @return
     */
    @GetMapping("/delAdders/{id}")
    public ResultData delAdders(@PathVariable("id")Long id);

}
