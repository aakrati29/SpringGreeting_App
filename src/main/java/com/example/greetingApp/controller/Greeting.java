package com.example.greetingApp.controller;

import com.example.greetingApp.services.GreetingServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/serviceparam")
    public String display(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        return greetingServices.getMessage(firstName, lastName);
    }

    @GetMapping("/greeting")
    public String display(){
        return "Demonstrate greeting controller..";
    }
}
