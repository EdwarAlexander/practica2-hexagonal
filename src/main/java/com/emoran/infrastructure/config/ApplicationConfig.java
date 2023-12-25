package com.emoran.infrastructure.config;

import com.emoran.application.service.ProductoService;
import com.emoran.application.usecase.ProductoServiceImpl;
import com.emoran.domain.ports.out.ProductoOut;
import com.emoran.infrastructure.repository.ProductoRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ProductoService productoService(ProductoOut productoOut){
        return new ProductoService(new ProductoServiceImpl(productoOut));
    }

    @Bean
    public ProductoOut productoOut(ProductoRepositoryAdapter productoRepositoryAdapter){
        return productoRepositoryAdapter;
    }
}
