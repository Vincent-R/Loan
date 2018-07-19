package com.loan.filter;

import com.alibaba.fastjson.JSON;
import com.loan.util.Constant;
import com.loan.util.DataReturn;
import com.loan.util.TokenSecurity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

//@WebFilter(urlPatterns = {"/*"}, filterName = "TokenFilter")
@Order(Integer.MAX_VALUE-1)
public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String url = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
        if(!url.contains("login")){
            String token = httpServletRequest.getHeader("token");//header方式
            DataReturn<String> resultInfo = null;
            if (null == token || token.isEmpty()) {
                resultInfo = new DataReturn<>(Constant.AUTHORIZE_FAILED, "用户授权认证没有通过!客户端请求参数中无token信息", "");
            } else {
                try {
                    Claims claims = TokenSecurity.validateToken(token, Constant.stringKey);
                    httpServletRequest.setAttribute("userId", claims.getId());
                }catch (MalformedJwtException | SignatureException e){
                    resultInfo = new DataReturn<>(Constant.AUTHORIZE_FAILED, "token无效", "");
                    //System.out.println("无效token");
                }catch (ExpiredJwtException e){
                    resultInfo = new DataReturn<>(Constant.AUTHORIZE_FAILED, "token过时，请重新登录！", "");
                    //System.out.println("过时token");
                }catch (Exception e) {
                    resultInfo = new DataReturn<>(Constant.AUTHORIZE_FAILED, "token验证发生错误", "");
                    e.printStackTrace();
                }
            }
            if (resultInfo!=null && resultInfo.getStatus() == Constant.AUTHORIZE_FAILED) {// 验证失败
                httpServletResponse.setStatus(403);
                PrintWriter writer = null;
                OutputStreamWriter osw = null;
                try {
                    osw = new OutputStreamWriter(httpServletResponse.getOutputStream(), "UTF-8");
                    writer = new PrintWriter(osw, true);
                    String jsonStr = JSON.toJSONString(resultInfo);
                    writer.write(jsonStr);
                    writer.flush();
                    writer.close();
                    osw.close();
                } catch (UnsupportedEncodingException e) {
                    System.out.println("过滤器返回信息失败:" + e.getMessage());
                } catch (IOException e) {
                    System.out.println("过滤器返回信息失败:" + e.getMessage());
                } finally {
                    if (null != writer) {
                        writer.close();
                    }
                    if (null != osw) {
                        try {
                            osw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }else{
                try {
                    httpServletResponse.setHeader("token", token);
                    filterChain.doFilter(servletRequest, servletResponse);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
