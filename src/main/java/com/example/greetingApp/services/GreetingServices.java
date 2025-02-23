package com.example.greetingApp.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServices {

    public String getMessage(){
        return "Hello world!";
    }


    public String getMessage(String firstName, String lastName){
        if(firstName != null && lastName != null){
            return "firstName : " + firstName + ", lastName : " + lastName;
        }
        else if(firstName != null){
            return firstName;
        }
        else if(lastName != null){
            return lastName;
        }
        else{
            return "Hello world!";
        }
    }
}
