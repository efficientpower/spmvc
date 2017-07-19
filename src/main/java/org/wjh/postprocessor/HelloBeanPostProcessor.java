package org.wjh.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class HelloBeanPostProcessor implements BeanPostProcessor {

    public HelloBeanPostProcessor() {
        // TODO Auto-generated constructor stub
        System.out.println("HelloBeanPostProcessor 初始化");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloBeanPostProcessor postProcessBeforeInitialization " + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloBeanPostProcessor postProcessAfterInitialization " + beanName);
        return bean;
    }

}
