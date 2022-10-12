package com.sparta.springcore.controller;

import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.model.Comment;
import com.sparta.springcore.repository.CommentRepository;
import com.sparta.springcore.repository.PostRepository;
import com.sparta.springcore.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @PostMapping("/api/comments")
    public void saveComment(@RequestBody CommentDto commentDto) {
        commentService.saveComment(commentDto);
    }

    @GetMapping("/api/comments/{id}")
    public Comment findOneComment(@PathVariable Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
    }

    @GetMapping("/api/comments")
    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }
}
