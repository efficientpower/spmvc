package org.wjh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(100)
@Component
public class HelloAnnotationAopAspect {

    //execution(public * org.wjh..*.HelloNotifier.*(..))
    @Pointcut("execution(public * org.wjh.service..*.*(..))")
    public void HelloAnnotationAopAspectPointcut() {
    }
    
    @Before("HelloAnnotationAopAspectPointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("HelloAnnotationAopAspect =====@Before===== method=" + joinPoint.getSignature().getName());
    }

    @After("HelloAnnotationAopAspectPointcut()")
    public void after(JoinPoint joinPoint){
        System.out.println("HelloAnnotationAopAspect =====@After===== method=" + joinPoint.getSignature().getName());
    }

    @AfterReturning("HelloAnnotationAopAspectPointcut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("HelloAnnotationAopAspect =====@AfterReturning===== method=" + joinPoint.getSignature().getName());
    }

    @Around("HelloAnnotationAopAspectPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        /**
         * 环绕通知连接点参数必须是ProceedingJoinPoint类型,他是JoinPoint的子类,需要明确调用ProceedingJoinPoint.proceed()方法
         * 如果忘记会导致通知被执行,但是目标方法没有执行。
         * 环绕通知需要返回目标方法执行后的结果,否则可能会导致空指针异常
         */
        System.out.println("HelloAnnotationAopAspect =====@Around(before)===== method=" + joinPoint.getSignature().getName());
        Object val = joinPoint.proceed();
        System.out.println("HelloAnnotationAopAspect =====@Around(after)===== method=" + joinPoint.getSignature().getName());
        return val;
    }

    @AfterThrowing("HelloAnnotationAopAspectPointcut()")
    public void afterThrowing(JoinPoint joinPoint) throws Throwable{
        System.out.println("HelloAnnotationAopAspect =====@AfterThrowing===== method=" + joinPoint.getSignature().getName());
    }
}
