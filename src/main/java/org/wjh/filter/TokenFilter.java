package org.wjh.filter;

import org.wjh.common.WebUser;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TokenFilter implements Filter {

    private String token;

    public void setPath(String path) {
        this.token = path;
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        this.token = filterConfig.getInitParameter("token");
        System.out.println(TokenFilter.class.getName() + " init, token=" + token);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        try {

            String mobToken = ((HttpServletRequest)request).getHeader(token);
            WebUser wu = new WebUser();
            wu.setUserId(mobToken);
            wu.setIp(request.getRemoteAddr());
            wu.setDeviceId("12345666777");
            WebUser.setWebUser(wu);

            System.out.println(TokenFilter.class.getName() + " doFilter");
            chain.doFilter(request, response);
            System.out.println(TokenFilter.class.getName() + " doFilter after");
        } catch (Exception e) {

        } finally {
            System.out.println(TokenFilter.class.getName() + " finally");
        }

    }

    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println(TokenFilter.class.getName() + " destroy");
    }

}
