package com.mars.elleshop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liujiulong
 * @date 2019/09/29  10:14:00
 */
@WebFilter("/*")
public class CrossFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        //任意ip都可以访问
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        //httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,accept,content-type,token,uname");
        //允许任意请求头
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        //允许跨域的方法提交方式
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, resp);

    }

    @Override
    public void destroy() {

    }
}
