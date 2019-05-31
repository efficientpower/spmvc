package org.wjh.annotation;

import java.lang.annotation.*;

/**
 * 判定是否需要登录
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface User {

}
