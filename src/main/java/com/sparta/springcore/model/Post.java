package com.sparta.springcore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.springcore.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String contents;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    public Post(PostDto postDto) {
        this.title = postDto.getTitle();
        this.contents = postDto.getContents();
    }
}
