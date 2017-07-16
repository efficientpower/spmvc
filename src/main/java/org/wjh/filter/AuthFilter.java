package org.wjh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println(AuthFilter.class.getName() + " init");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        try{
            System.out.println(AuthFilter.class.getName() + " doFilter");
            chain.doFilter(request, response);
            System.out.println(AuthFilter.class.getName() + " doFilter after");
        }catch(Exception e){
            
        }finally {
            System.out.println(AuthFilter.class.getName() + " finally");
        }
    }

    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println(AuthFilter.class.getName() + " destroy");
    }

}
