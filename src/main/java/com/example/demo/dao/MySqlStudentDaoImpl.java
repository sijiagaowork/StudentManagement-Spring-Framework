package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
@Qualifier("mySQL")
public class MySqlStudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student s = new Student();
        s.setId(resultSet.getInt("id"));
        s.setName(resultSet.getString("name"));
        s.setCourse(resultSet.getString("course"));
        return s;
    }
    @Override
    public Collection<Student> getStudents() {
        String sql = "SELECT id, name, course FROM students";
        List<Student> students = jdbcTemplate.query(sql, this::mapRow);
        return students;
    }

    @Override
    public void setStudents(Map<Integer, Student> students) {

    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT id, name, course FROM students WHERE id = ?";
        Student student = jdbcTemplate.queryForObject(sql, this::mapRow, id);
        return student;
    }

    @Override
    public void removeStudentById(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void addStudentById(int id, int studentID, String name, String course) {

    }

    @Override
    public void updateStudent(Student student) {
        int id = student.getId();
        String name = student.getName();
        String course = student.getCourse();

        String sql = "UPDATE students" +
                "       SET name = ?, course = ?" +
                "        WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{name, course, id});

    }

    @Override
    public void insertStudent(Student student) {
//        int id = student.getId();
        String name = student.getName();
        String course = student.getCourse();

//        String sql = "INSERT INTO students(id, name, course) " +
////                "       VALUES(id, name, course) ";
        String sql = "INSERT INTO students(name, course) " +
                "       VALUES(?, ?) ";

        jdbcTemplate.update(sql, new Object[]{name, course});
    }
}
