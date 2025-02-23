package com.example.greetingApp.controller;

import com.example.greetingApp.services.GreetingServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // Find a greeting by ID
    @GetMapping("/{id}")
    public ResponseEntity<com.example.greetingApp.entities.Greeting> getGreetingById(@PathVariable Long id) {
        Optional<com.example.greetingApp.entities.Greeting> greeting = greetingServices.findGreetingById(id);
        return greeting.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public com.example.greetingApp.entities.Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        return greetingServices.updateGreeting(id, updatedGreeting.greetingServices.getMessage());
    }

    @DeleteMapping("/greetDBDelete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingServices.deleteGreeting(id);
        return "Greeting with ID " + id + " deleted successfully!";
    }
}
