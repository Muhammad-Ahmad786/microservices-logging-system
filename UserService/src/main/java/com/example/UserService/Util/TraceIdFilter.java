package com.example.UserService.Util;

import java.io.IOException;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(2)
public class TraceIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
  
            String traceId = request.getHeader("X-Trace-Id");

            TraceIdHolder.set(traceId);

            try{
                filterChain.doFilter(request, response);
            }
            finally{
                TraceIdHolder.clear();
            }
  
  
     }



}
