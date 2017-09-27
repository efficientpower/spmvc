package org.wjh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAopAspect {

    @Pointcut("execution(public * org.wjh..*.*(..))")
    public void hello() {
    }
    
    @Before("hello()")
    public void before(JoinPoint joinPoint){
        System.out.println("@Before method=" + joinPoint.getTarget());
    }

    @After("hello()")
    public void after(JoinPoint joinPoint){
        System.out.println("@After method=" + joinPoint.getTarget());
    }
}
