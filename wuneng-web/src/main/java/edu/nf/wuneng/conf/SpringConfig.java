package edu.nf.wuneng.conf;

import edu.nf.wuneng.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author YXD
 * @date 2020/4/2
 */
@Configuration
public class SpringConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html", "/index.html","/login","/register","/code", "/js/**", "/css/**","/font/**","/image/**","/images/**","/layui/**","/picture/**","/plugins/**","/src/**","/assets/**");
    }
}