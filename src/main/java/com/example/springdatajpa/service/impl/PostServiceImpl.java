package com.example.springdatajpa.service.impl;


import com.example.springdatajpa.mapper.PostMapper;
import com.example.springdatajpa.model.Post;
import com.example.springdatajpa.model.PostDto;
import com.example.springdatajpa.model.PostFullInfoDto;
import com.example.springdatajpa.model.PostUpsertForm;
import com.example.springdatajpa.predicate.PostPredicate;
import com.example.springdatajpa.repo.PostRepository;
import com.example.springdatajpa.service.PostService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<PostDto> findAll() {
        List<PostDto> list = new ArrayList<>();
        postRepository.findAll().forEach(post -> {
            list.add(postMapper.toPostDto(post));
        });
        return list;
    }

    @Override
    public List<PostDto> findAllByUserUsername(String username) {
        List<PostDto> list = new ArrayList<>();
        postRepository.findAllByUserUsername(username).forEach(post -> {
            list.add(postMapper.toPostDto(post));
        });
        return list;
    }

    @Override
    public List<PostDto> findAllByTitle(String title) {
        List<PostDto> list = new ArrayList<>();
        postRepository.findAllByTitle(title).forEach(post -> {
            list.add(postMapper.toPostDto(post));
        });
        return list;
    }

    @Override
    public List<PostDto> findAll(Predicate predicate) {
        List<PostDto> list = new ArrayList<>();
        postRepository.findAll(predicate).forEach(post -> {
            list.add(postMapper.toPostDto(post));
        });
        return list;
    }

    @Override
    public PostFullInfoDto findById(Long id) {
        Post post = postRepository.findPostByIdQuery(id);
        return postMapper.toFullInfoDto(post);
    }

    @Override
    public void save(PostUpsertForm upsertForm) {
        postRepository.save(postMapper.toEntity(upsertForm));

    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
