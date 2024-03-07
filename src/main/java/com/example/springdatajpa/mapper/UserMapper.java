package com.example.springdatajpa.mapper;

import com.example.springdatajpa.model.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserMapper {


    public PostDto toPostDto(Post post) {
        if (post == null) return null;
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setTitle(post.getTitle());
        if (post.getUser() == null) {
            postDto.setUsername(null);
        } else {
            postDto.setUsername(post.getUser().getUsername());
        }

        return postDto;
    }
    public UserFullInfoDto toUserFullInfoDto(User user) {
        UserFullInfoDto userDto = new UserFullInfoDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        Set<PostDto> postDtoSet = new HashSet<>();
        user.getPost().forEach((post -> {
            postDtoSet.add(toPostDto(post));
        }));
        userDto.setPostDto(postDtoSet);
        return userDto;
    }

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        return userDto;
    }
}
