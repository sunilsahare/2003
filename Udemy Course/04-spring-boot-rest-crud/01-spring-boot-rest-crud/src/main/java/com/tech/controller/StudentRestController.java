package com.tech.controller;

import com.tech.entity.Student;
import com.tech.entity.Test;
import jakarta.annotation.PostConstruct;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;
    @PostConstruct
    private void loadData() {
        this.students = List.of(
                new Student("Sunil", "Sahare"),
                new Student("Sunny", "Rathi"),
                new Student("Martin", "Richards")
        );
    }
    @GetMapping("/students")
    public List<Student> getAllStudent() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Test> response = template.getForEntity("https://jsonplaceholder.typicode.com/todos/1", Test.class);
        System.err.println("response "+response);
        System.err.println("===================================================");
        Test responseBody = response.getBody();
        System.err.println("responsebody:=> "+responseBody);
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getSTudent(@PathVariable Integer studentId) {
        if (studentId>= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }

}
