package com.example.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class GatwayConfig {

    @Autowired
    AuthenticationFilter filter;



    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/citizen/**")
                        .filters(f -> f.rewritePath("/citizen/(?<s>.*)","/${s}").filter(filter))
                        .uri("http://localhost:8095/"))

                .route("auth-service", r -> r.path("/auth/**")
                        .filters(f -> f.rewritePath("/auth/(?<s>.*)","/${s}").filter(filter))
                        .uri("http://localhost:8094/"))
                .build();
    }

}
