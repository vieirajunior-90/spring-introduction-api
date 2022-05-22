package com.learningspring.intro.controller;

import com.learningspring.intro.model.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setPhone("(21) 99999-9999");
        user.setEmail("johndoe@yahoo.com.br");
        user.setPassword("123456");
        return ResponseEntity.ok().body(user);
    }
}
