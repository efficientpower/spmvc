package org.wjh.aop;

import org.aspectj.lang.JoinPoint;

public class HelloXmlAopAspect {

    public void before(JoinPoint joinPoint) {
        System.out.println("HelloXmlAopAspect before method=" + joinPoint.getTarget());
    }

    public void after(JoinPoint joinPoint) {
        System.out.println("HelloXmlAopAspect after method=" + joinPoint.getTarget());
    }
}
