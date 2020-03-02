package com.springboot.service.posts;

import com.springboot.domain.posts.Posts;
import com.springboot.domain.posts.PostsRepository;
import com.springboot.dto.PostsListRequestDto;
import com.springboot.dto.PostsListResponseDto;
import com.springboot.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return PostsResponseDto.builder()
                .entity(posts)
                .build();
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAll(Pageable pageable) {
        return postsRepository.findAll(pageable).stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllByTitle(String title, Pageable pageable) {
        return postsRepository.findAllByTitle(title, pageable).stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
