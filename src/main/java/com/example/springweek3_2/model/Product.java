package com.example.springweek3_2.model;

@Entity
public class Product extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private Long userId;
    private String title;
    private String image;
    private String link;
    private int lprice;
    private int myprice;
}