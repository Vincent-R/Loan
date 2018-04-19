package com.loan.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"}, filterName = "CorsFilter")
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        //设置允许跨域的配置
        // 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        // 允许的访问方法
        httpServletResponse.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept");

        httpServletResponse.setHeader("Access-Control-Expose-Headers","token");

        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
