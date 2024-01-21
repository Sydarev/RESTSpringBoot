package com.example.sb_resthw.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.RequestParam;

public class User {
    @NotBlank
    @Min(3)
    public String name;
    @NotBlank
    @Min(1)
    public String password;

    public User(@RequestParam("name") String name, @RequestParam("pass") String password){
        this.name = name;
        this.password = password;
    }
}
