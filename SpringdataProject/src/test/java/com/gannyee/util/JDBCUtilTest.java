package com.gannyee.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class JDBCUtilTest {

    @Test
    public void getConnection() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = JDBCUtil.getConnection();
        Assert.assertNotNull(connection);
    }
}