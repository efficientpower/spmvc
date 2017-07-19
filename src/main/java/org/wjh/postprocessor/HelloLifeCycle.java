package org.wjh.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloLifeCycle implements InitializingBean, DisposableBean, 
        BeanFactoryAware, BeanNameAware, ApplicationContextAware, BeanPostProcessor {

    public HelloLifeCycle() {
        // TODO Auto-generated constructor stub
        System.out.println("HelloLifeCycle 构造方法");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle postProcessBeforeInitialization beanName=" + beanName);
        return null;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle postProcessAfterInitialization beanName=" + beanName);
        return null;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle setApplicationContext");
    }

    public void setBeanName(String name) {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle setBeanName");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle setBeanFactory");
    }

    public void destroy() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle destory");
    }

    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle afterPropertiesSet");
    }
    
    public void helloInit(){
        System.out.println("HelloLifeCycle init-method helloInit");
    }
    
    public void helloDestory(){
        System.out.println("HelloLifeCycle destory-method helloDestory");
    }
}
