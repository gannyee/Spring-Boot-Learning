package com.gannyee.dao;

import com.gannyee.domain.Student;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOImplTest {

    @Test
    public void testQuery() throws SQLException {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();
        for (Student student : students){
            System.out.println("id:" + student.getId() +
                    " name:" + student.getName() +
            " age: " + student.getAge());
        }

    }
}