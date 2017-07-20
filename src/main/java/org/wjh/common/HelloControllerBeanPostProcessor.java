package org.wjh.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class HelloControllerBeanPostProcessor implements BeanPostProcessor {

    public HelloControllerBeanPostProcessor() {
        // TODO Auto-generated constructor stub
        System.out.println("HelloControllerBeanPostProcessor 构造方法");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloControllerBeanPostProcessor postProcessBeforeInitialization() beanName=" + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloControllerBeanPostProcessor postProcessAfterInitialization()  beanName=" + beanName);
        return bean;
    }

}
