package com.stormling.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Author: StormLing
 * @Description:
 * @Date: Created in 11:30 2020-05-29
 * @Modified By:
 */
@Aspect
public class LogAspects {
    //抽取公共的切入点表达式
    //1、本类引用
    //2、其他的切面引用
    @Pointcut("execution(public int com.stormling.aop.MathCalculator.*(..))")
    private void pointCut(){};

    //@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
    //JoinPoint一定要出现在参数列表的第一位
    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinpoint) {
        System.out.println("logStart>>>>"+joinpoint.getSignature().getName()+">>>>"+ Arrays.toString(joinpoint.getArgs()));
    }

    @After(value ="com.stormling.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinpoint) {
        System.out.println("logEnd>>>>>"+joinpoint.getSignature().getName()+">>>>"+Arrays.toString(joinpoint.getArgs()));
    }

    @AfterReturning(value ="execution(public int com.stormling.aop.MathCalculator.*(..))",returning="object")
    public void logReturn(Object object) {
        System.out.println("logReturn>>>>"+object);
    }

    @AfterThrowing(value = "execution(public int com.stormling.aop.MathCalculator.*(..))",throwing = "object")
    public void logException(Exception object) {
        System.out.println("logException>>>>"+object);
    }
}
