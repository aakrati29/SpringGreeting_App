package com.example.greetingApp.services;

import com.example.greetingApp.entities.Greeting;
import com.example.greetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingServices {

    private final GreetingRepository greetingRepository;

    public GreetingServices(GreetingRepository greetingRepository){
        this.greetingRepository = greetingRepository;
    }

    // Save greeting message
    public Greeting saveGreeting(String message) {
        Greeting greeting =  new Greeting(message);
        return greetingRepository.save(greeting);
    }

    // Get all saved greetings
    public List<Greeting> getAllGreetings() {
         return greetingRepository.findAll();
    }

    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

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
