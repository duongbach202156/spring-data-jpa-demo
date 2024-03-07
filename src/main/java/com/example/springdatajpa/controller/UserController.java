package com.example.springdatajpa.controller;


import com.example.springdatajpa.model.User;
import com.example.springdatajpa.model.UserDto;
import com.example.springdatajpa.model.UserFullInfoDto;
import com.example.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAllUser() {
        return userService.findAll();
    }
    @GetMapping(value = "/{id}")
    public UserFullInfoDto getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{userId}/{postId}")
    public void getUserById(@PathVariable("userId") Long id, @PathVariable("postId") Long postId) {
        userService.deletePostByPostId(id, postId);
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);
    }

}
