package com.sparta.springcore.model;

import com.sparta.springcore.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(CommentDto commentDto, Post post) {
        this.contents = commentDto.getContents();
        this.post = post;
    }
}
