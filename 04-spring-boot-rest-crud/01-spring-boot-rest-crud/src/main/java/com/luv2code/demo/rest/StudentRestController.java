package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Spring REST Service using @RestController
@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define a field, load the field with data, do it only once
    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students") // endpoint
    public List<Student> getStudents() {
        return theStudents;
    }

    // define new endpoit or "/student/{studentId}" - return student at index
    @GetMapping("/students/{studentId}") // endpoint | studentId is Path variable
    public Student getStudent(@PathVariable int studentId) {
        // just index into the list ... keep it simple for now

        // check the studentId again list size
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }
}