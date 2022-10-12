package com.sparta.springcore.service;

import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.model.Comment;
import com.sparta.springcore.model.Post;
import com.sparta.springcore.repository.CommentRepository;
import com.sparta.springcore.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public void saveComment(CommentDto commentDto) {


        Post post = postRepository.findById(commentDto.getPostid()).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        Comment comment = new Comment(commentDto, post);
        commentRepository.save(comment);
    }
}
