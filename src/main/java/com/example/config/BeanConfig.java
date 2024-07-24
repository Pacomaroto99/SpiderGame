package com.example.config;

import com.example.game.GameFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public GameFactory factory() {
        return new GameFactory();
    }
}
