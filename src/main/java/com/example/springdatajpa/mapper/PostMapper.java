package com.example.springdatajpa.mapper;

import com.example.springdatajpa.model.*;
import com.example.springdatajpa.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    @Autowired
    private UserRepository userRepository;

    public Post toEntity(PostUpsertForm postUpsertForm) {
        if (postUpsertForm == null) return null;
        Post post = new Post();
        post.setTitle(postUpsertForm.getTitle());
        post.setContent(postUpsertForm.getContent());
        User user = userRepository.findUserById(postUpsertForm.getUserId());
        post.setUser(user);
        return post;
    }

    public PostFullInfoDto toFullInfoDto(Post post) {
        if (post == null) return null;
        PostFullInfoDto postDto = new PostFullInfoDto();
        postDto.setId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setTitle(post.getTitle());
        if (post.getUser() == null) {
            postDto.setUser(null);
        } else {
            postDto.setUser(toUserDto(post.getUser()));
        }
        return postDto;
    }

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

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
}
