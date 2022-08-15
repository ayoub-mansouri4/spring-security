package com.example.security.controllers;

import com.example.security.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome Ayoub";
    }
    @PostMapping("/user")
    public String getUser(@RequestBody User user){
        return user.toString();
    }
}
