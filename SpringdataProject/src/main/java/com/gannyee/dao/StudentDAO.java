package com.gannyee.dao;

import com.gannyee.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * StudentDAO访问接口
 */
public interface StudentDAO {

    /**
     * 查询所有的学生
     * @return
     */
    public List<Student> query() throws SQLException;


}
