package com.restaurante.plato.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean("consumirApiIngrediente")
    public RestTemplate registroTemplate() {
        return new RestTemplate();
    }
}
