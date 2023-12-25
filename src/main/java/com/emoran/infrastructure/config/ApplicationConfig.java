package com.emoran.infrastructure.config;

import com.emoran.application.service.FacturaCabeceraService;
import com.emoran.application.service.FacturaDetalleService;
import com.emoran.application.service.ProductoService;
import com.emoran.application.usecase.FacturaCabeceraServiceImpl;
import com.emoran.application.usecase.FacturaDetalleServiceImpl;
import com.emoran.application.usecase.ProductoServiceImpl;
import com.emoran.domain.ports.out.FacturaCabeceraOut;
import com.emoran.domain.ports.out.FacturaDetalleOut;
import com.emoran.domain.ports.out.ProductoOut;
import com.emoran.infrastructure.repository.FacturaCabeceraRepositoryAdapter;
import com.emoran.infrastructure.repository.FacturaDetalleRepositoryAdapter;
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

    @Bean
    public FacturaCabeceraService facturaCabeceraService(FacturaCabeceraOut facturaCabeceraOut){
        return new FacturaCabeceraService(new FacturaCabeceraServiceImpl(facturaCabeceraOut));
    }

    @Bean
    public FacturaCabeceraOut facturaCabeceraOut(FacturaCabeceraRepositoryAdapter facturaCabeceraRepositoryAdapter){
        return facturaCabeceraRepositoryAdapter;
    }

    @Bean
    public FacturaDetalleService facturaDetalleService(FacturaDetalleOut facturaDetalleOut){
        return new FacturaDetalleService(new FacturaDetalleServiceImpl(facturaDetalleOut));
    }

    @Bean
    public FacturaDetalleOut facturaDetalleOut(FacturaDetalleRepositoryAdapter facturaDetalleRepositoryAdapter){
        return facturaDetalleRepositoryAdapter;
    }
}
