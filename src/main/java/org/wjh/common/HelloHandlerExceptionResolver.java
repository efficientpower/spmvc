package org.wjh.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.google.gson.Gson;

/**
 * 公共异常处理
 */
public class HelloHandlerExceptionResolver implements HandlerExceptionResolver {
    Log log = LogFactory.getLog(HelloHandlerExceptionResolver.class);
    private static Gson gson = new Gson();

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            HandlerMethod hm = (HandlerMethod)handler;
            log.error("处理错误：" + hm.getClass().getName() +"." + hm.getMethod().getName(), ex);
            throw ex;
        } catch (CommonException e) {
            Result<Object> res = new Result<Object>(e.getCode(), e.getMsg());
            writer.write(gson.toJson(res));
            writer.flush();
        } catch (Exception e) {
            Result<Object> res = new Result<Object>(Code.FAIL.getCode(), Code.FAIL.getMsg());
            writer.write(gson.toJson(res));
            writer.flush();
        }finally{
            if(writer != null){
                writer.close();
            }
        }
        return null;
    }
}
