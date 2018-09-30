package com.cms.kernel.config;

import com.cms.kernel.interceptor.AdminLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AdminInterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        AdminLoginInterceptor adminLoginInterceptor = new AdminLoginInterceptor();
        InterceptorRegistration ir = registry.addInterceptor(adminLoginInterceptor);
        ir.addPathPatterns("/admin/**");
        List<String> excludeList = new ArrayList<>();
        excludeList.add("/admin/login");
        ir.excludePathPatterns(excludeList);
    }


}
