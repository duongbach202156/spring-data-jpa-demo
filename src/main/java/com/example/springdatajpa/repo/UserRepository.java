package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Post;
import com.example.springdatajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

}
