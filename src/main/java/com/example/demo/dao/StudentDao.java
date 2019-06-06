package com.example.demo.dao;

import com.example.demo.entity.Student;

import java.util.Collection;
import java.util.Map;

public interface StudentDao {
    // Collection 根据values结果是collection 来的
    Collection<Student> getStudents();

    void setStudents(Map<Integer, Student> students);

    Student getStudentById(int id);

    void removeStudentById(int id);

    void addStudentById(int id, int studentID, String name, String course);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
