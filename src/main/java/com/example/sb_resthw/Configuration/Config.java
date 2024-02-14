package com.example.sb_resthw.configuration;

import com.example.sb_resthw.repository.UserRepository;
import com.example.sb_resthw.service.AuthorizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public UserRepository getUserRepository() {
        return new UserRepository();
    }

    @Bean
    public AuthorizationService getAuthorizationService() {
        return new AuthorizationService(getUserRepository());
    }
}
