package org.wjh.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.wjh.common.HelloNotifier;
import org.wjh.annotation.User;
import org.wjh.service.UserService;

@Controller
public class HelloController {

    @Autowired
    UserService userService;
    @Autowired
    HelloNotifier helloNotifier;
    
    public HelloController() {
        System.out.println("HelloController 构造方法");
        // TODO Auto-generated constructor stub
    }

    @ResponseBody
    @RequestMapping("/wjh/hello.do")
    public Object hello(@RequestParam(value="arg", required=false, defaultValue="1") Integer arg){
        if(arg.equals(1)){
            userService.getUserName("wangjihui");
        }else if(arg.equals(2)){
            userService.getUserId("wangjihui");
        }else if(arg.equals(3)){
            userService.getAll();
        }else{
            helloNotifier.send();
        }
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("name", "xiaoming");
        res.put("age", 27);
        res.put("arg", arg);
        return res;
    }

    @User
    @ResponseBody
    @RequestMapping("/wjh/{age}/say.do")
    public Object say(HttpServletRequest request,
            @RequestParam("name") String name,
            @PathVariable("age") Integer age,
            @RequestHeader("user-agent") String userAgent){
        Map<String, Object> res = new LinkedHashMap<String, Object>();

        ServletContext  context = request.getServletContext();
        XmlWebApplicationContext rootContext = (XmlWebApplicationContext)context.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
        XmlWebApplicationContext childContext = (XmlWebApplicationContext)context.getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
        String[] rootNames = rootContext.getBeanDefinitionNames();
        String[] childNames = childContext.getBeanDefinitionNames();
        rootContext.getBean("car");
        Map<String,Object> headers = new LinkedHashMap<String,Object>();
        Enumeration<String> henus = request.getHeaderNames();
        while(henus.hasMoreElements()){
            String hn = henus.nextElement();
            String val = request.getHeader(hn);
            headers.put(hn, val);
        }
        res.put("servletName", request.getServerName());
        res.put("servletPath", request.getServletPath());
        res.put("serverName", request.getServerName());
        res.put("contextPath", request.getContextPath());
        res.put("method", request.getMethod());
        res.put("headers", headers);
        res.put("cookies", request.getCookies());
        res.put("URI", request.getRequestURI());
        res.put("URL", request.getRequestURL());
        res.put("sessionId", request.getRequestedSessionId());
        res.put("port", request.getServerPort());
        res.put("serverInfo", context.getServerInfo());
        res.put("protocol", request.getProtocol());
        res.put("rootNames", rootNames);
        res.put("childNames",childNames);
        return res;
    }
}
