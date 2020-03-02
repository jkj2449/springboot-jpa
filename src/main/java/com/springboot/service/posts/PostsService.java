package com.springboot.service.posts;

import com.springboot.domain.posts.Posts;
import com.springboot.domain.posts.PostsRepository;
import com.springboot.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService implements ApplicationRunner {
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return PostsResponseDto.builder()
                .entity(posts)
                .build();
    }

    @Override
    public void run(ApplicationArguments args) {
        List<Posts> postsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            postsList.add(Posts.builder()
                    .title("제목" + i)
                    .content("내용" + i)
                    .author("이름" + i)
                    .build());
        }

        for (Posts posts : postsList) {
            postsRepository.save(posts);
        }
    }
}
