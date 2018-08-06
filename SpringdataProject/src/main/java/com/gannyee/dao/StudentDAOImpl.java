package com.gannyee.dao;

import com.gannyee.domain.Student;
import com.gannyee.util.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO 访问接口实现类：通过最原始的JDBC方式操作
 */
public class StudentDAOImpl implements StudentDAO {
    public StudentDAOImpl() {
    }

    @Override
    public List<Student> query() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select id,name,age from student";
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            Student student = null;
            while (resultSet.next()){
                student = new Student();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                student.setId(id);
                student.setName(name);
                student.setAge(age);

                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
        return students;
    }
}
