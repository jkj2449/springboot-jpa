package com.springboot.config;

import com.springboot.domain.comment.Comment;
import com.springboot.domain.comment.CommentRepository;
import com.springboot.domain.posts.Posts;
import com.springboot.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class InitData {
    private final PostsRepository postsRepository;
    private final CommentRepository commentRepository;

    @PostConstruct
    public void initData() {
        initPosts();
    }

    public void initPosts() {
        for (int i = 0; i < 10; i++) {
            Posts posts = createPosts(i);
            //postsRepository.save(posts);
            commentRepository.save(createComment(posts, i));
        }
    }

    private Posts createPosts(int i) {
        return Posts.builder()
                .title("title" + i)
                .content("content" + i)
                .author("author" + i)
                .build();
    }

    private Comment createComment(Posts posts, int i) {
        return Comment.builder()
                .comment("comment" + i)
                .author("author" + i)
                .build();
    }
}
