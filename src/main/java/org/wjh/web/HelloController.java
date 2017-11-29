package org.wjh.web;

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
    
    @ResponseBody
    @RequestMapping("/wjh/{age}/say.do")
    public Object say(HttpServletRequest request,
            @RequestParam("name") String name,
            @PathVariable("age") Integer age,
            @RequestHeader("user-agent") String userAgent){
        Map<String, Object> res = new LinkedHashMap<String, Object>();
        String servletName = request.getServerName();
        String servletPath = request.getServletPath();
        String contextPath = request.getContextPath();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        
        ServletContext  context = request.getServletContext();
        String serverInfo = context.getServerInfo();
        
        XmlWebApplicationContext rootContext = (XmlWebApplicationContext)context.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
        XmlWebApplicationContext childContext = (XmlWebApplicationContext)context.getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
        String[] names = rootContext.getBeanDefinitionNames();
        String[] cnames = childContext.getBeanDefinitionNames();
        rootContext.getBean("car");
        res.put("servletName", servletName);
        res.put("servletPath", servletPath);
        res.put("serverName", serverName);
        res.put("contextPath", contextPath);
        res.put("port", port);
        res.put("serverInfo", serverInfo);
        res.put("rootNames", names);
        res.put("childNames",cnames);
        return res;
    }
}
