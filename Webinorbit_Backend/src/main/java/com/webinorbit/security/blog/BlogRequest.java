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
    private Integer readTime; // Changed from readtime
    private String author;
    private String authorImage; // Changed from authorimage
    private String date;
    private String tags;
    private String category;
    private String sectionTitle; // Changed from section_title
    private String sectionContent; // Changed from section_content
}

