package com.tworuszka.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Michał Tworuszka
 * @project Bank App
 */

@Order(1)
@Component
public class TraceFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(TraceFilter.class);
    @Autowired
    private FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders responseHeaders = exchange.getRequest().getHeaders();
        if(isCorrelationIdPresent(responseHeaders)) {
            logger.debug("Bank-correlation-id found in tracing filter: {}. "
            ,filterUtility.getCorrelationId(responseHeaders));
        } else {
            String correlationId = generateCorrelationId();
            exchange = filterUtility.setCorrelationId(exchange, correlationId);
            logger.debug("Bank-correlation-id generated in tracing filter: {}.", correlationId);
        }
        return chain.filter(exchange);
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }

    private boolean isCorrelationIdPresent(HttpHeaders responseHeaders) {
        if (filterUtility.getCorrelationId(responseHeaders) != null) {
            return true;
        } else {
            return false;
        }
    }
}
