package com.sparta.springcore.dto;

import com.sparta.springcore.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDto {

    private Long postid;
    private String contents;

    public CommentDto(Comment comment) {
        this.contents = comment.getContents();
    }
}
