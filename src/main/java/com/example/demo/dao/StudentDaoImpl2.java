package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Repository
@Qualifier("version2")
public class StudentDaoImpl2 implements StudentDao{

    @Override
    public Collection<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(12, "version2name", "version2Course"));
        return students;
    }

    @Override
    public void setStudents(Map<Integer, Student> students) {

    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void addStudentById(int id, int studentID, String name, String course) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
