package com.example.sb_resthw.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestParam;

public class User {
    @NotBlank
    @Min(3)
    private final String name;
    @NotBlank
    @Min(1)
    private final String password;

    public User(@RequestParam("name") String name, @RequestParam("pass") String password){
        this.name = name;
        this.password = password;
    }
}
