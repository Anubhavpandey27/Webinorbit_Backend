package com.webinorbit.security.blog;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BlogRequest {

    private String title;
    private String image;
    private String description;
    private  int readtime;
    private String author;
    private String authorimage;
    private String date;
    private String tags;
    private  String category;
    private String section_title;
    private String section_content;

}
