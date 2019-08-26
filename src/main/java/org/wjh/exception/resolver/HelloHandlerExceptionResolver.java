package org.wjh.exception.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.google.gson.Gson;
import org.wjh.common.Code;
import org.wjh.common.Result;
import org.wjh.exception.CommonException;

/**
 * 公共异常处理解析器
 */
public class HelloHandlerExceptionResolver implements HandlerExceptionResolver {
    public static Logger logger = LoggerFactory.getLogger(HelloHandlerExceptionResolver.class);
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
            logger.error("处理错误：{}.{}", hm.getClass().getName(), hm.getMethod().getName(), e);
        } catch (Exception e) {
            logger.error("处理错误：{}.{}", hm.getClass().getName(), hm.getMethod().getName(), e);
        } finally {
            if (writer != null) {
                writer.write(gson.toJson(res));
                writer.flush();
                writer.close();
            }
        }
        return null;
    }
}
