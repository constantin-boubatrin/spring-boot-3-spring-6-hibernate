package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
            // the default is singleton, so all the dependency injections for the bean will reference the SAME bean
            // if we add Scope the instances will reference the DIFFERENT bean
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.anotherCoach = theAnotherCoach;
    }

    @GetMapping("/check")
    public String check() {
        // singleton: true | Prototype: false
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }
}