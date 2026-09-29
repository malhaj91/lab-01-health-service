package com.mohammadalhaj.healthservice.api;

import java.time.Instant;

public record GreetingResponse(
        String message,
        Instant timestamp
) {
}