package com.example.springdatajpa.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;
@Data
public class UserDto implements Serializable {
    private Long id;

    private String username;

    private String email;

}
