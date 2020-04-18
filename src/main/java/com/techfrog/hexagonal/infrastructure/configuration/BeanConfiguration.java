package com.techfrog.hexagonal.infrastructure.configuration;

import com.techfrog.hexagonal.DomainLayerApplication;
import com.techfrog.hexagonal.domain.repository.OrderRepository;
import com.techfrog.hexagonal.domain.service.DomainOrderService;
import com.techfrog.hexagonal.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DomainLayerApplication.class)
public class BeanConfiguration {

    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }
}
