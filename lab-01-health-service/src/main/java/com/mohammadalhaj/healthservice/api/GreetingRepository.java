package com.mohammadalhaj.healthservice.api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

    List<Greeting> findAllByOrderByTimestampDesc();
}
