package com.manufacturing.storagecenter.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 检查用户是否已经登录
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        
        // 如果用户已登录，允许访问
        if (loggedIn != null && loggedIn) {
            return true;
        }
        
        // 用户未登录，重定向到登录页面
        response.sendRedirect("/login");
        return false;
    }
} 