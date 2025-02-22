package com.example.greetingApp.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServices {

    public String getMessage(){
        return "Hello world!";
    }
}
