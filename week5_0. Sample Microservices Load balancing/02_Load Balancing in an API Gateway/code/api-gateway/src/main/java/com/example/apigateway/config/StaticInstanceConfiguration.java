package com.example.apigateway.config;

import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;

@Configuration
public class StaticInstanceConfiguration {

    @Bean
    public ServiceInstanceListSupplier exampleServiceInstanceSupplier() {
        return new ServiceInstanceListSupplier() {
            @Override
            public String getServiceId() {
                return "example-service";
            }

            @Override
            public Flux<List<ServiceInstance>> get() {
                List<ServiceInstance> instances = List.of(
                        new DefaultServiceInstance("example-service-1", "example-service", "localhost", 8081, false),
                        new DefaultServiceInstance("example-service-2", "example-service", "localhost", 8082, false)
                );
                return Flux.just(instances);
            }
        };
    }
}
