package com.mlorenzo.gateway.security;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ApiKeyAuthorizationFilter implements GlobalFilter, Ordered {
    private final ApiKeyAuthorizationChecker apiKeyAuthorizationChecker;

    public ApiKeyAuthorizationFilter(ApiKeyAuthorizationChecker apiKeyAuthorizationChecker) {
        this.apiKeyAuthorizationChecker = apiKeyAuthorizationChecker;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("ApiKeyAuthorizationFilter... checking the key");
        // Obtiene la ruta que coincide con la petición http
        Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        List<String> apiKey = exchange.getRequest().getHeaders().get("ApiKey");
        if(route == null || route.getId() == null || apiKey == null || apiKey.isEmpty() ||
                !apiKeyAuthorizationChecker.isAuthorized(apiKey.get(0), route.getId()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You are not authorized!");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
