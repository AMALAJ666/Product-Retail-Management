package com.gateway.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}
	@Bean

	public RouteLocator configureRoute(RouteLocatorBuilder builder) {

	       return builder.routes()

	      .route("customer", r->r.path("/client1/**").uri("lb://customer")) //dynamic routing

	      .route("product", r->r.path("/client2/**").uri("lb://product")) //dynamic routing
	      .build();

	    }

}
