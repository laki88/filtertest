package org.laki.filtertest.controllers;

import org.laki.filtertest.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping(path = "/{userName}", produces = "application/json")
    public User getUser(@PathVariable String userName) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        return new User().setUserName(userDetails.getUsername());
    }
}
