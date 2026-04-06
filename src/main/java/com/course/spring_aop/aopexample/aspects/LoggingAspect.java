package com.course.spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
    public void logMethodCallBeforeExecution(JoinPoint joinPoint){
        //JoinPoint to get the details
        //Logic - What?
        logger.info("Before Aspect - {} is called with arguments -{}", joinPoint, joinPoint.getArgs());
    }

    @After("execution(* com.course.spring_aop.aopexample.*.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint){
        logger.info("After Aspect - {} has executed", joinPoint);
    }

    @AfterThrowing(
            pointcut = "execution(* com.course.spring_aop.aopexample.*.*.*(..))",
            throwing ="exception")
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception){
        logger.info("AfterThrowing Aspect - {} has thrown an exception ", joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "execution(* com.course.spring_aop.aopexample.*.*.*(..))",
            returning = "resultValue")
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue){
        logger.info("After returning Aspect - {} has returned {}", joinPoint, resultValue);
    }
}
