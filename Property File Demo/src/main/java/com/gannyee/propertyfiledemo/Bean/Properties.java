package com.gannyee.propertyfiledemo.Bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

    @Value("${com.gannyee.name}")
    private String name;
    @Value("${com.ganyee.title}")
    private String title;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}
