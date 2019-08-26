package org.wjh.annotationconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.wjh.common.HelloNotifier;

/**
 * 测试 @Configuration @Import @Bean @Value 的使用
 * 
 * @author wangjihui
 *
 */
@Configuration
@Import(ConfigurationBeanValueAnnotationClassSub.class)
public class ConfigurationBeanValueAnnotationClassRoot {

    //注入已经实例化的类
    @Value("#{helloNotifier}")
    private HelloNotifier helloNotifier;
    //注入普通字符串常量方式1
    @Value("#{'wangjihui'}")
    private String name;
    //注入普通字符串常量方式2
    @Value("wangjihui")
    private String name2;
    //注入某个类的属性
    @Value("#{helloInitializingBeanAndAware.duration}")
    private Integer duration;
    //通过调用某个类的方法注入属性
    @Value("#{helloInitializingBeanAndAware.getDuration()}")
    private Integer duration1;
    //注入整型常量
    @Value("#{1}")
    private Integer count;
    //引用系统的变量
    @Value("#{systemProperties['java.vm.vendor']}")
    private String systemProperties;
    //引用PropertyPlaceholderConfigurer中的属性
    //@Value("${jdbc.url}")
    //private String properties;

    @Bean
    public HelloNotifier get(){
        helloNotifier.send();
        return helloNotifier;
    }
}
