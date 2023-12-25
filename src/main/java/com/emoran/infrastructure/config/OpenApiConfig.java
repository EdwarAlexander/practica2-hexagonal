package com.emoran.infrastructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Practica Hexagonal", version = "1.0",
                description = "documentacion de endpoint de practica hexagonal",
                contact = @io.swagger.v3.oas.annotations.info.Contact(name = "Edwar Moran", email = "edwar.moran.12@gmail.com")
        )
)
public class OpenApiConfig {
}
