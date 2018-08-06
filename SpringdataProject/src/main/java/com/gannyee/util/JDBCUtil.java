package com.gannyee.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC 工具类
 * 1）获取CConnection
 * 2）释放资源
 */
public class JDBCUtil {


    /**
     * 获取Connection
     * @return 所获得的JDBC的Connection
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

        //配置不建议硬编码在代码里 建议写到配置文件
        /*String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.11.106:3306/spring_data";
        String user = "root";
        String password = "root123";*/
        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");

        Properties properties = new Properties();
        properties.load(inputStream);
        String driverClassName = properties.getProperty("jdbc.driverClassName");
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        Class.forName(driverClassName);
        return DriverManager.getConnection(url,user,password);
    }

    public static void release(ResultSet resultSet,
                               Statement statement,Connection connection) throws SQLException {
        if (null != resultSet){
            resultSet.close();
        }

        if (null != statement){
            statement.close();
        }

        if (null != connection){
            connection.close();
        }
    }
}
