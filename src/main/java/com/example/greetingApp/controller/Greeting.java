package com.example.greetingApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {

    @GetMapping("/greeting")
    public String display(){
        return "Demonstrate greeting controller..";
    }
}
