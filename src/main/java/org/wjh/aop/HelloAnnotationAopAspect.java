package org.wjh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAnnotationAopAspect {

    @Pointcut("execution(public * org.wjh..*.*(..))")
    public void HelloAnnotationAopAspectPointcut() {
    }
    
    @Before("HelloAnnotationAopAspectPointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("HelloAnnotationAopAspect @Before method=" + joinPoint.getTarget());
    }

    @After("HelloAnnotationAopAspectPointcut()")
    public void after(JoinPoint joinPoint){
        System.out.println("HelloAnnotationAopAspect @After method=" + joinPoint.getTarget());
    }
}
