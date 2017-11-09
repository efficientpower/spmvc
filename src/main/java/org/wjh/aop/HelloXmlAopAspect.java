package org.wjh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class HelloXmlAopAspect {

    public void before(JoinPoint joinPoint) {
        System.out.println("HelloXmlAopAspect =====before===== method=" + joinPoint.getSignature().getName());
    }

    public void after(JoinPoint joinPoint) {
        System.out.println("HelloXmlAopAspect =====after===== method=" + joinPoint.getSignature().getName());
    }

    public void afterReturning(JoinPoint joinPoint){
        System.out.println("HelloXmlAopAspect =====afterReturning===== method=" + joinPoint.getSignature().getName());
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        /**
         * 环绕通知连接点参数必须是ProceedingJoinPoint类型,他是JoinPoint的子类,需要明确调用ProceedingJoinPoint.proceed()方法
         * 如果忘记会导致通知被执行,但是目标方法没有执行。
         * 环绕通知需要返回目标方法执行后的结果,否则可能会导致空指针异常
         */
        System.out.println("HelloXmlAopAspect =====around--before===== method=" + joinPoint.getSignature().getName());
        Object val = joinPoint.proceed();
        System.out.println("HelloXmlAopAspect =====around--after===== method=" + joinPoint.getSignature().getName());
        return val;
    }

    public void afterThrowing(JoinPoint joinPoint) throws Throwable{
        System.out.println("HelloXmlAopAspect =====afterThrowing===== method=" + joinPoint.getSignature().getName());
    }
}
