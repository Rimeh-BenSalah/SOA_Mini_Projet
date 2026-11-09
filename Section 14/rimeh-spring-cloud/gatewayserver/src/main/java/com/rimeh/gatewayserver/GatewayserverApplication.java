package com.rimeh.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }

    @Bean
    public RouteLocator myRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/api/themes/**").uri("lb://THEME"))
                .route(p -> p.path("/api/livres/**").filters( f -> f.circuitBreaker(config -> config.setName("livreCircuitBreaker").setFallbackUri("forward:/contactAdmin"))).uri("lb://LIVRE"))
                .build();
    }

}
