package com.example.springdatajpa.service.impl;


import com.example.springdatajpa.mapper.UserMapper;
import com.example.springdatajpa.model.Post;
import com.example.springdatajpa.model.User;
import com.example.springdatajpa.model.UserDto;
import com.example.springdatajpa.model.UserFullInfoDto;
import com.example.springdatajpa.repo.PostRepository;
import com.example.springdatajpa.repo.UserRepository;
import com.example.springdatajpa.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtoList = new ArrayList<>();
        userRepository.findAll().forEach((user) -> {
            userDtoList.add(userMapper.toUserDto(user));
        });
        return userDtoList;
    }

    @Override
    public UserFullInfoDto findById(Long id) {
        return userMapper.toUserFullInfoDto(userRepository.findUserById(id));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deletePostByPostId(Long userId, Long postId) {
//        User user = userRepository.findUserById(userId);
        Post post = postRepository.findPostByIdQuery(postId);
//        user.getPost().remove(post);
        post.setUser(null);
        postRepository.save(post);
//        postRepository.save(post);
//        userRepository.save(user);
    }


}
