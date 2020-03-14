package com.aaa.lee.repast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenAnnotation {

    /**
     * 每次从浏览器过来的token值
     *  没有就默认
     */
    String Tkoen() default "";

}
