package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Post;
import com.example.springdatajpa.predicate.PostPredicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, ListQuerydslPredicateExecutor<Post> {
    List<Post> findAllByUserUsername(String username);


    @Query("select p from Post p where p.id = ?1")
    Post findPostByIdQuery(Long id);

    @Query(value = "SELECT * FROM posts WHERE title = :title", nativeQuery = true)
    List<Post> findAllByTitle(@Param("title") String title);

//    List<Post> findAll(Predicate predicate);

    Post findByIdAndUserId(Long id, Long userId);

}
