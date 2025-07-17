package com.example.apigateway.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class ResponseTimeFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        // Add header BEFORE the response is committed
        exchange.getResponse().getHeaders().add("X-Timestamp", LocalDateTime.now().toString());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1; // high priority
    }
}