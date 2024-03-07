package com.example.springdatajpa.predicate;

import com.example.springdatajpa.model.QPost;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

public class PostPredicate {
    private static final QPost post = QPost.post;

    public static BooleanBuilder getPredicate(final PostParam postParam) {
        BooleanBuilder where = new BooleanBuilder();
        return where.and(matchTitle(postParam.getTitle()))
                .and(matchUsername(postParam.getUsername()));
    }

    public static BooleanExpression matchTitle(String title) {
        return title == null ? null : post.title.eq(title);
    }

    public static BooleanExpression matchUsername(String username) {
        return username == null ? null : post.user.username.eq(username);
    }
}
