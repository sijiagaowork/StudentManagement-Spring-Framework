package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("version1")
public class StudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students = new HashMap<>();

    static {
        students.put(1, new Student(1, "sijia", "CS"));
        students.put(2, new Student(2, "dabendan", "SE"));
        students.put(3, new Student(3, "conner", "music"));
    }

    // Collection 根据values结果是collection 来的
    @Override
    public Collection<Student> getStudents() {
        return this.students.values(); // values 根据key-value pair来的
    }

    @Override
    public void setStudents(Map<Integer, Student> students) {
        StudentDaoImpl.students = students;
    }

    @Override
    public Student getStudentById(int id){
        return this.students.get(id); // return values
    }

    @Override
    public void removeStudentById(int id){
        students.remove(id);
    }

    @Override
    public void addStudentById(int id, int studentID, String name, String course){
        students.put(id, new Student(studentID, name, course));
    }

    @Override
    public void updateStudent(Student student){
        // get from user
        Student s = students.get(student.getId());
        // 如果没有以下两行就会变成插入新的 老得还在
        s.setCourse(student.getCourse());
        s.setName(student.getName());

        // put back to db
        students.put(s.getId(), student);
    }

    @Override
    public void insertStudent(Student student){
        students.put(student.getId(), student);
    }

}
