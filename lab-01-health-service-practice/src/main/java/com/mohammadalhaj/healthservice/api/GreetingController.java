package com.mohammadalhaj.healthservice.api;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

    @GetMapping("/greetings")
    public GreetingResponse greeting(
            @RequestParam(defaultValue = "Developer") String name
    ) {
        return new GreetingResponse(
                "Hello, " + name + "!",
                Instant.now()
        );
    }
}