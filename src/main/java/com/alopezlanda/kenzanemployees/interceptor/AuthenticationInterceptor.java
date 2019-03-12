package com.alopezlanda.kenzanemployees.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alopezlanda.kenzanemployees.exception.UnauthorizedException;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor{
  
  private String token;

  @Autowired
  public AuthenticationInterceptor(Environment env) {
    token = env.getProperty("kenzan.auth-token");
  }
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String headerToken = request.getHeader("auth-token");
    if(StringUtils.isNotEmpty(headerToken)) {
      if(token.equalsIgnoreCase(headerToken))
        return true;
    }
    
    throw new UnauthorizedException("Token is not valid");
  }
  

}
