package org.wjh.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

public class HelloBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public HelloBeanFactoryPostProcessor() {
        // TODO Auto-generated constructor stub
        System.out.println("HelloBeanFactoryPostProcessor 初始化");
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloBeanFactoryPostProcessor postProcessBeanFactory");
    }

}
