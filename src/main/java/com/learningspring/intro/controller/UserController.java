package com.learningspring.intro.controller;

import com.learningspring.intro.model.entities.Order;
import com.learningspring.intro.model.entities.User;
import com.learningspring.intro.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user.getOrders() != null && !user.getOrders().isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User has orders. Cannot delete");
        }
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody User user) {
        User existingUser = userService.findById(id);
        BeanUtils.copyProperties(user, existingUser, "id");
        User updatedUser = userService.save(existingUser);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }
}
