package com.example.springdatajpa.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostFullInfoDto implements Serializable {
    private Long id;

    private String title;

    private String content;

    private UserDto user;
}
