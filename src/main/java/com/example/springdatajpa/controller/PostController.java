package com.example.springdatajpa.controller;



import com.example.springdatajpa.model.Post;
import com.example.springdatajpa.model.PostDto;
import com.example.springdatajpa.model.PostFullInfoDto;
import com.example.springdatajpa.model.PostUpsertForm;
import com.example.springdatajpa.predicate.PostParam;
import com.example.springdatajpa.predicate.PostPredicate;
import com.example.springdatajpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDto> getAllPost(@RequestParam(name="username", required = false) String username) {
        if (username == null) return postService.findAll();
        return postService.findAllByUserUsername(username);
    }

    @GetMapping("/")
    public List<PostDto> getAllPostByTitle(@RequestParam(name="title", required = false) String title) {
        if (title == null) return postService.findAll();
        return postService.findAllByTitle(title);
    }

    @GetMapping("/querydsl")
    public List<PostDto> getAll(PostParam postParam) {
        return postService.findAll(PostPredicate.getPredicate(postParam));
    }


    @GetMapping(value = "/{id}")
    public PostFullInfoDto getPostById(@PathVariable(value = "id") Long id) {
        return postService.findById(id);
    }

    @PostMapping
    public void savePost(@RequestBody PostUpsertForm post) {
        postService.save(post);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePostById(@PathVariable("id") Long id) {
        postService.delete(id);
    }
}
