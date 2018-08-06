package com.gannyee.springjdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataTest {

    private ApplicationContext ctx = null;


    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("beans-news.xml");
        System.out.println("set up");
    }

    @After
    public void tearDown() throws Exception {
        ctx = null;
        System.out.println("tear down");
    }

    @Test
    public void testEntityManagerFactory(){

    }
}
