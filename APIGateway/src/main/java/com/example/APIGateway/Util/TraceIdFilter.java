package com.example.APIGateway.Util;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class TraceIdFilter implements GlobalFilter {

   @Value("${gateway.secret}")
   private String secret;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
  
           String traceId = UUID.randomUUID().toString();

           ServerHttpRequest request = exchange.getRequest()
                                       .mutate()
                                       .header("X-Trace-Id", traceId)
                                       .header("X-Internal-Gateway", secret)
                                       .build();

            return chain.filter(
                                exchange.mutate()
                                .request(request)
                                .build()
                            );
  
    }

    



}
