package org.wjh.postprocessor;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

public class HelloInitializingBean implements InitializingBean {

    public HelloInitializingBean() {
        // TODO Auto-generated constructor stub
        System.out.println("HelloInitializingBean 初始化");
    }

    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("HelloInitializingBean afterPropertiesSet");
    }

}
