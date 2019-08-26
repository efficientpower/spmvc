package org.wjh.annotationconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeanValueAnnotationClassSub {

    //引用系统的变量
    @Value("#{systemProperties['java.vm.vendor']}")
    private String javaVmVendor;

}
