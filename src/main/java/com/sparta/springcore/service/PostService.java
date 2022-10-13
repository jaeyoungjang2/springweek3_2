package com.sparta.springcore.service;

import com.sparta.springcore.dto.CommentDto;
import com.sparta.springcore.dto.PostDto;
import com.sparta.springcore.model.Comment;
import com.sparta.springcore.model.Post;
import com.sparta.springcore.repository.CommentRepository;
import com.sparta.springcore.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostDto findDetail(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("id가 존재하지 않습니다."));

        List<Comment> comments = post.getComments();

        List<CommentDto> commentDto = new ArrayList<>();

        for (Comment comment : comments) {
            CommentDto commentResponseDto = new CommentDto(comment);
            commentDto.add(commentResponseDto);
        }

        return new PostDto(post, commentDto);
    }
}
