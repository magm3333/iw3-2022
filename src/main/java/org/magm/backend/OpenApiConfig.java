package org.magm.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
 
  ///Doc: https://springdoc.org/#Introduction

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Backend - Ing Web 3")
                        .description("API Backend - Ing Web 3")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("magm")
                                .url("https://github.com/magm3333")
                                .email("magm@iua.edu.ar"))
                        .termsOfService("TOC")
                        .license(new License().name("License").url("#"))
                );
    }
}

