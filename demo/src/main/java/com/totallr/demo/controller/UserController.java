package com.totallr.demo.controller;

import com.totallr.demo.model.Response;
import com.totallr.demo.model.User;
import com.totallr.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping
    public Iterable<User> viewUsers() {
        return service.viewUsers();
    }

    @PostMapping
    public Response addUser(@RequestBody User user) {
        return service.createUser(user);
    }
}
