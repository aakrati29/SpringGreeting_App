package com.example.greetingApp.controller;

import com.example.greetingApp.services.GreetingServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
    private GreetingServices greetingServices;

    Greeting(GreetingServices greetingServices){
        this.greetingServices = greetingServices;
    }

    @GetMapping("/service")
    public String getGreeting(){
        return greetingServices.getMessage();
    }

    @GetMapping("/greeting")
    public String display(){
        return "Demonstrate greeting controller..";
    }
}
