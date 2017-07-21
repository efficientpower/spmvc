package org.wjh.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class HelloLifeCycle implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware,
        ResourceLoaderAware, ApplicationContextAware {

    private Integer duration;

    public HelloLifeCycle() {
        // TODO Auto-generated constructor stub
        System.out.println("HelloLifeCycle 构造方法");
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        System.out.println("HelloLifeCycle.setDuration() duration=" + duration);
        this.duration = duration;
    }

    public void setBeanName(String name) {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle Aware[BeanNameAware] setBeanName() name=" + name);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle Aware[BeanFactoryAware] setBeanFactory()");
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle Aware[ResourceLoaderAware] setResourceLoader()");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle Aware[ApplicationContextAware] setApplicationContext()");
        String[] beanPostProcessNames = applicationContext.getBeanNamesForType(BeanPostProcessor.class);
        for(String name : beanPostProcessNames){
            System.out.println("   ======HelloLifeCycle beanPostProcess=" + name);
        }
        String[] beanFactoryPostProcessNames = applicationContext.getBeanNamesForType(BeanFactoryPostProcessor.class);
        for(String name : beanFactoryPostProcessNames){
            System.out.println("   ******HelloLifeCycle beanFactoryPostProcessor=" + name);
        }
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String name : beanNames){
            System.out.println("   ######HelloLifeCycle beanName=" + name);
        }
    }

    public void destroy() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle destory()");
    }

    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("HelloLifeCycle afterPropertiesSet()");
    }

    public void helloInit() {
        System.out.println("HelloLifeCycle init-method helloInit()");
    }

    public void helloDestory() {
        System.out.println("HelloLifeCycle destory-method helloDestory()");
    }

}
