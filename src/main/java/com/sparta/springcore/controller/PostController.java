package com.sparta.springcore.controller;

import com.sparta.springcore.dto.PostDto;
import com.sparta.springcore.model.Post;
import com.sparta.springcore.repository.PostRepository;
import com.sparta.springcore.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @PostMapping("/api/posts")
    public void savePost(@RequestBody PostDto postDto) {
        Post post = new Post(postDto);
        postRepository.save(post);
    }

    @GetMapping("/api/posts/{id}")
    public PostDto findOnePost(@PathVariable Long id) {

        return postService.findDetail(id);
    }

    @GetMapping("/api/posts")
    public List<Post> findOnePost() {
        return postRepository.findAll();
    }
}
