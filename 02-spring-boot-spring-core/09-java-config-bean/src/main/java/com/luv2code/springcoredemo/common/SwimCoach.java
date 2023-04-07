package com.luv2code.springcoredemo.common;

// Does not have @Component annotation because
// we configured as a Spring bean using @Bean
public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In construcotr: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }
}