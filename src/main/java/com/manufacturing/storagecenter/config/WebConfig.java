package com.manufacturing.storagecenter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/login/authenticate", "/static/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 重定向根路径到登录页面
        registry.addRedirectViewController("/", "/login");
    }
} 