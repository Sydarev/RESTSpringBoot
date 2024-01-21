package com.example.sb_resthw.Configuration;

import com.example.sb_resthw.Repository.UserRepository;
import com.example.sb_resthw.Service.AuthorizationService;
import com.example.sb_resthw.controller.AuthorizationController;
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

//    @Bean
//    public AuthorizationController getAuthorizationController() {
//        return new AuthorizationController();
//    }
}
