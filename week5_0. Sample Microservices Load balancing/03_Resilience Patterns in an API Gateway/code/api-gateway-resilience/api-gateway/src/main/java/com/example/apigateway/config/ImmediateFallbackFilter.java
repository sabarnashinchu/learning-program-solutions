package com.example.apigateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component("ImmediateFallbackFilter")
public class ImmediateFallbackFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        return chain.filter(exchange)
            .onErrorResume(Exception.class, ex -> {
                ServerHttpRequest fallbackRequest = exchange.getRequest().mutate()
                        .path("/fallback/dummy")
                        .build();
                ServerWebExchange fallbackExchange = exchange.mutate().request(fallbackRequest).build();
                return fallbackExchange.getResponse().writeWith(
                    Mono.just(fallbackExchange.getResponse()
                        .bufferFactory()
                        .wrap("Fallback response: Dummy backend service is currently unavailable.".getBytes()))
                );
            });
    }

    @Override
    public int getOrder() {
        return -1; // High precedence
    }
}