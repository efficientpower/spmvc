package org.wjh.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class HelloInitializingBeanAndAware implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware,
        ResourceLoaderAware, ApplicationContextAware {

    private Integer duration;

    public HelloInitializingBeanAndAware() {
        // TODO Auto-generated constructor stub
        System.out.println("HelloInitializingBeanAndAware 构造方法");
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        System.out.println("HelloInitializingBeanAndAware.setDuration() duration=" + duration);
        this.duration = duration;
    }

    public void setBeanName(String name) {
        // TODO Auto-generated method stub
        System.out.println("HelloInitializingBeanAndAware Aware[BeanNameAware] setBeanName() name=" + name);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloInitializingBeanAndAware Aware[BeanFactoryAware] setBeanFactory()");
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        // TODO Auto-generated method stub
        System.out.println("HelloInitializingBeanAndAware Aware[ResourceLoaderAware] setResourceLoader()");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("HelloInitializingBeanAndAware Aware[ApplicationContextAware] setApplicationContext()");
    }

    public void destroy() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("HelloInitializingBeanAndAware destory()");
    }

    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("HelloInitializingBeanAndAware afterPropertiesSet()");
    }

    public void helloInit() {
        System.out.println("HelloInitializingBeanAndAware init-method helloInit()");
    }

    public void helloDestory() {
        System.out.println("HelloInitializingBeanAndAware destory-method helloDestory()");
    }

}
