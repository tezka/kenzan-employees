package com.alopezlanda.kenzanemployees.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alopezlanda.kenzanemployees.interceptor.AuthenticationInterceptor;

@Configuration
public class WebMvcConfig implements  WebMvcConfigurer {

  @Autowired AuthenticationInterceptor authInterceptor;
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authInterceptor).addPathPatterns("/kenzan/v1/employee/secure/**");
  }
    

}
