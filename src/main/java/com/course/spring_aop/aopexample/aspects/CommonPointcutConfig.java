package com.course.spring_aop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.course.spring_aop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}

    @Pointcut("@annotation(com.course.spring_aop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}

