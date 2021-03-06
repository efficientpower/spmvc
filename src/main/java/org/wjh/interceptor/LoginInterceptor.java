package org.wjh.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.wjh.annotation.User;
import org.wjh.common.Code;
import org.wjh.exception.CommonException;
import org.wjh.common.WebUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    public static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler !=null && HandlerMethod.class.isAssignableFrom(handler.getClass())){
            HandlerMethod hm = (HandlerMethod)handler;
            Annotation annotation = AnnotationUtils.getAnnotation(hm.getMethod(), User.class);
            if(annotation != null && !WebUser.hasLogin()){
                throw new CommonException(Code.NOT_LOGIN.getMsg(), Code.NOT_LOGIN.getCode());
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("LoginInterceptor.postHandle()");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("LoginInterceptor.afterCompletion()");
    }
}
