package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.dao.StudentDaoImpl;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier("mySQL")
    private StudentDao dao;

    public Collection<Student> getStudents() {
        return dao.getStudents(); // values 根据key-value pair来的
    }

    public Student getStudentById(int id){
        return dao.getStudentById(id); // return values
    }

    public void removeStudentById(int id){
        dao.removeStudentById(id);
    }

    public void addStudentById(int id, int studentID, String name, String course){
        dao.addStudentById(id, studentID, name, course);
    }

    public void updateStudent(Student student){
        dao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        dao.insertStudent(student);
    }

}
