package org.laki.filtertest.controllers;

import org.laki.filtertest.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping(path="/{id}", produces = "application/json")
    public User getUser(@PathVariable int id) {
        return new User();
    }
}
