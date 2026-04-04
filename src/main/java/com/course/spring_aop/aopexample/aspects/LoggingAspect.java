package com.course.spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //PointCut - When?
    //execution for all classes in a package execution(* PACKAGE.*.*(..))
    @Before("execution(* com.course.spring_aop.aopexample.*.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint){
        //JoinPoint to get the details
        //Logic - What?
        logger.info("Before Aspect - Method is called -{}", joinPoint);
    }
}
