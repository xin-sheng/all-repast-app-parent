package com.aaa.lee.repast.aspect;

import com.aaa.lee.repast.controller.MemberController;
import com.aaa.lee.repast.service.IRepastService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Slf4j
@Aspect
@Component
public class TokenAspect {

    @Autowired
    private MemberController memberController;

    /**
     * @author Seven Lee
     * @description
     *      就是为了定义切面，也就是说让AOP在哪里生效
     *      也就是说当AOP检测到LoginLogAnnotation注解的时候，被该注解所标识的方法就会执行
     *      切面业务代码
     * @param []
     * @date 2020/3/11
     * @return void
     * @throws
     **/
    @Pointcut("@annotation(com.aaa.lee.repast.annotation.TokenAnnotation)")
    public void pointcut() {
        // TODO nothing todo
    }

    @Before("pointcut()")
    public void Before(JoinPoint point){
        Object[] args = point.getArgs();
        Boolean TokenBoolean = memberController.GetToken(args.toString());
            if(!TokenBoolean){
                throw new RuntimeException();
            }
//        for (Object arg : args) {
//            System.out.println(arg);
//        }
        }


}
