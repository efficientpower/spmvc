package org.wjh.interceptor;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.wjh.annotation.User;
import org.wjh.common.Code;
import org.wjh.common.CommonException;
import org.wjh.common.WebUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler !=null && handler.getClass().isAssignableFrom(HandlerMethod.class)){
            HandlerMethod hm = (HandlerMethod)handler;
            Annotation annotation = AnnotationUtils.getAnnotation(hm.getMethod(), User.class);
            if(annotation != null && !WebUser.hasLogin()){
                throw new CommonException(Code.NOT_LOGIN.getMsg(), Code.NOT_LOGIN.getCode());
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
