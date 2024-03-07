package com.example.springdatajpa.model;

import lombok.Data;

import java.util.Set;

@Data
public class UserFullInfoDto {
    private Long id;

    private String username;

    private String email;

    private Set<PostDto> postDto;
}
