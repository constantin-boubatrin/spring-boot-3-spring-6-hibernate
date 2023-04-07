package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component // annotation marks the class as a Spring bean makes it available for dependency injection
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }
}