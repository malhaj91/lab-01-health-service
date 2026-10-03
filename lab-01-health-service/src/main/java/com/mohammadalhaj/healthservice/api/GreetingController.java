package com.mohammadalhaj.healthservice.api;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

    private final GreetingRepository greetingRepository;

    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @PostMapping("/greetings")
    public GreetingResponse greeting(
            @Valid @RequestBody GreetingRequest request) {
        Instant timestamp = Instant.now();
        String name = request.getName();
        String message = "Hello, " + name + "!";
        greetingRepository.save(new Greeting(name, message, timestamp));
        return new GreetingResponse(message, timestamp);
    }

    @GetMapping("/greetings/history")
    public List<GreetingResponse> history() {
        return greetingRepository.findAllByOrderByTimestampDesc().stream()
                .map(greeting -> new GreetingResponse(
                        greeting.getMessage(), greeting.getTimestamp()))
                .toList();
    }
}
