package com.example.sb_resthw.controller;

import com.example.sb_resthw.Authorities;
import com.example.sb_resthw.exceptions.InvalidCredentials;
import com.example.sb_resthw.exceptions.UnauthorizedUser;
import com.example.sb_resthw.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(@Qualifier("getAuthorizationService") AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredentialsHandler(RuntimeException e){
        return new ResponseEntity<>( e.getMessage(), HttpStatusCode.valueOf(400));
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedUserHandler(RuntimeException e){
        System.out.println(e.getMessage());
        return new ResponseEntity<>( e.getMessage(), HttpStatusCode.valueOf(401));
    }
}
