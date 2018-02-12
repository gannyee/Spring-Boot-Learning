package com.gannyee.accessingdatawithmysql.controller;

import com.gannyee.accessingdatawithmysql.bean.User;
import com.gannyee.accessingdatawithmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";

    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<User> getAllUser() {
        return userRepository.findAll();
    }
}
