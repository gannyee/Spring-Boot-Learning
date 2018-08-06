package com.gannyee.springjdbc;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DataResourceTest {

    private ApplicationContext ctx = null;


    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("set up");
    }

    @After
    public void tearDown() throws Exception {
        ctx = null;
        System.out.println("tear down");
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);
    }
}
