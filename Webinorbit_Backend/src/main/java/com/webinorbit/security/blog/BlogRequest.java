package com.webinorbit.security.blog;

import lombok.Data;

@Data
public class BlogRequest {
    private String title;
    private String image;
    private String description;
    private Integer read_time;
    private String author;
    private String author_image;
    private String date;
    private String tags;
    private String category;
    private String section_title;
    private String section_content;
}
