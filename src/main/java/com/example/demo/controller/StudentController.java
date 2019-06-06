package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getStudents() {
        return service.getStudents(); // values 根据key-value pair来的
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return service.getStudentById(id); // return values
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/{id}")
    public void removeStudentById(@PathVariable("id") int id){
        service.removeStudentById(id);
    }

    // PUT is for update
    @RequestMapping(method = RequestMethod.PUT, consumes="application/json")
    public void updateStudent(@RequestBody Student student){
        service.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void insertStudent(@RequestBody Student student) {
        service.insertStudent(student);
    }
}
