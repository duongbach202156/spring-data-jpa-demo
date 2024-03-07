package com.example.springdatajpa.service;


import com.example.springdatajpa.model.Post;
import com.example.springdatajpa.model.PostDto;
import com.example.springdatajpa.model.PostFullInfoDto;
import com.example.springdatajpa.model.PostUpsertForm;
import com.example.springdatajpa.predicate.PostPredicate;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    List<PostDto> findAllByUserUsername(String username);
    List<PostDto> findAllByTitle(String title);

    List<PostDto> findAll(Predicate predicate);
    PostFullInfoDto findById(Long id);

    void save(PostUpsertForm post);

    void delete(Long id);
}
