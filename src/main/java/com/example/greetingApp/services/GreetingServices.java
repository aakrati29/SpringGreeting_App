package com.example.greetingApp.services;

import com.example.greetingApp.entities.Greeting;
import com.example.greetingApp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingServices {

    private final GreetingRepository greetingRepository;

    public GreetingServices (GreetingRepository greetingRepository){
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

    public Greeting updateGreeting(Long id, String newMessage) {
        Greeting existingGreeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));

        existingGreeting.setMessage(newMessage);
        return greetingRepository.save(existingGreeting);
    }

    //delete greeting
    public void deleteGreeting(Long id) {
        if (!greetingRepository.existsById(id)) {
            throw new RuntimeException("Greeting not found with ID: " + id);
        }
        greetingRepository.deleteById(id);
    }


    public String getMessage(){
        return "Hello world!";
    }

    public String getMessage(String firstName, String lastName){
        if (firstName != null && lastName != null){
             return "firstName : " + firstName + ", lastName : " + lastName;
        }
        else if (firstName != null){
            return firstName;
        }
        else if (lastName != null){
            return lastName;
        }
        else{
            return "Hello world!";
        }
    }
}
