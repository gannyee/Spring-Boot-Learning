package com.imooc.demo.config.service.impl;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import com.imooc.demo.service.impl.AreaServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void queryArea() {
        List<Area> areaList = areaService.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    public void queryAreaById() {

    }

    @Test
    public void addArea() {
    }

    @Test
    public void modifyArea() {
    }

    @Test
    public void deleteArea() {
    }
}