package org.wjh.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.google.gson.Gson;

/**
 * 公共异常处理解析器
 */
public class HelloHandlerExceptionResolver implements HandlerExceptionResolver {
    Log log = LogFactory.getLog(HelloHandlerExceptionResolver.class);
    private static Gson gson = new Gson();

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;
        HandlerMethod hm = (HandlerMethod) handler;
        Result<Object> res = new Result<Object>(Code.FAIL.getCode(), Code.FAIL.getMsg());
        try {
            writer = response.getWriter();
            throw ex;
        } catch (CommonException e) {
            res = new Result<Object>(e.getCode(), e.getMsg());
            if(!Code.NOT_LOGIN.getCode().equals(e.getCode())){
                log.error("处理错误：" + hm.getClass().getName() + "." + hm.getMethod().getName(), e);
            }
        } catch (Exception e) {
            log.error("处理错误：" + hm.getClass().getName() + "." + hm.getMethod().getName(), e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        writer.write(gson.toJson(res));
        writer.flush();
        return null;
    }
}
