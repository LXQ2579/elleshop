package com.mars.elleshop.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liujiulong
 * @date 2019/09/29  15:11:00
 */
//@Order(1)//filter优先级
@WebFilter("*.do")
public class LoginFilter implements Filter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.setCharacterEncoding("UTF-8");
        String method = req.getMethod();
        //向请求头中写入数据时, 会先发送一个提交方式为OPTIONS的请求
        //我们不同处理该请求, 直接返回
        if (method.equalsIgnoreCase("OPTIONS")) {
            return;
        }
        String uri = req.getRequestURI();
        if (uri.contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            String token = req.getHeader("token");
            String ajax = req.getHeader("x-request-with");

            if (token == null || "".equals(token)) {
                if (ajax != null && ajax.equals("XMLHttpRequest")) {

                    JsonBean<String> result = new JsonBean<>(0, "没有登录");
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonStr = objectMapper.writeValueAsString(result);
                    res.getWriter().write(jsonStr);
                    return;
                } else {
                    //跳转到登陆界面
                    res.sendRedirect(req.getContextPath() + "/login.html");
                }
            } else {
                String name = stringRedisTemplate.opsForValue().get(token);
                if (name == null) {
                    if (ajax != null && ajax.equals("XMLHttpRequest")) {
                        JsonBean<String> result = new JsonBean<>(0, "没有登录");
                        ObjectMapper objectMapper = new ObjectMapper();
                        String jsonStr = objectMapper.writeValueAsString(result);
                        res.getWriter().write(jsonStr);
                        return;
                    } else {
                        //跳转到登陆界面
                        res.sendRedirect(req.getContextPath() + "/login.html");
                    }

                }
                String token2 = MD5Utils.md5(name + "liujiulong");
                if (token.equals(token2)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    if (ajax != null && ajax.equals("XMLHttpRequest")) {
                        JsonBean<String> result = new JsonBean<>(0, "没有登录");
                        ObjectMapper objectMapper = new ObjectMapper();
                        String jsonStr = objectMapper.writeValueAsString(result);
                        res.getWriter().write(jsonStr);
                        return;
                    } else {
                        //跳转到登陆界面
                        res.sendRedirect(req.getContextPath() + "/login.html");
                    }
                }

            }
        }
    }

    @Override
    public void destroy() {

    }
}
