package com.example.greetingApp.controller;

import com.example.greetingApp.services.GreetingServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class Greeting {
    private final GreetingServices greetingServices;

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

    @PostMapping
    public com.example.greetingApp.entities.Greeting saveGreeting(@RequestParam String message) {
        return greetingServices.saveGreeting(message);
    }

    // Retrieve all saved greetings
    @GetMapping
    public List<com.example.greetingApp.entities.Greeting> getAllGreetings() {
        return greetingServices.getAllGreetings();
    }

    @GetMapping("/greeting")
    public String display(){
        return "Demonstrate greeting controller..";
    }
}
