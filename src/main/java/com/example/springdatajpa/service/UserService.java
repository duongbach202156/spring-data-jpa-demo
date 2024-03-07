package com.example.springdatajpa.service;


import com.example.springdatajpa.model.User;
import com.example.springdatajpa.model.UserDto;
import com.example.springdatajpa.model.UserFullInfoDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();
    UserFullInfoDto findById(Long id);

    void save(User user);

    void delete(Long id);

    void deletePostByPostId(Long userId, Long postId);
}
