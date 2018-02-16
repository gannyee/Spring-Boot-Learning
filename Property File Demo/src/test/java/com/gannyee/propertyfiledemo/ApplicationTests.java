package com.gannyee.propertyfiledemo;

import com.gannyee.propertyfiledemo.Bean.Properties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {


    @Autowired
    private Properties properties;


    @Test
    public void getHello() {
        Assert.assertEquals(properties.getName(), "¿ò¼Ü");
        Assert.assertEquals(properties.getTitle(), "Spring Boot");
    }
}
