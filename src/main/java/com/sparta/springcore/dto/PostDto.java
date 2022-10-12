package com.sparta.springcore.dto;

import com.sparta.springcore.model.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostDto {
    private String title;
    private String contents;
    private List<CommentDto> commentDtos;


    public PostDto(Post post, List<CommentDto> commentDtos) {
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.commentDtos = commentDtos;
    }
}
