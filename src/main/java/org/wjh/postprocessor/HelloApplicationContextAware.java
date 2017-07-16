package org.wjh.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class HelloApplicationContextAware implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public HelloApplicationContextAware() {
        System.out.println("HelloApplicationContextAware 初始化");
        // TODO Auto-generated constructor stub
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloApplicationContextAware setApplicationContext");
        applicationContext = context;
    }
    
    public Object getBean(String name){
        return applicationContext.getBean(name);
    }
}
