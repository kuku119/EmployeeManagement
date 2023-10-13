package pkg.cty.employeemanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pkg.cty.employeemanagement.interceptor.WebInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");

        registry.addViewController("/main").setViewName("main");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebInterceptor interceptor = new WebInterceptor();
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/static/**",
                        "/index", "/user/login"
                );
    }
}
