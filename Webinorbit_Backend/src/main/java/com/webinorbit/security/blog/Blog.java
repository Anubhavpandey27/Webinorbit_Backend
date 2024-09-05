package com.webinorbit.security.blog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Blog {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String image;
    private String description;
    private Integer readTime; // Changed to Integer

    // Changed from readtime
    private String author;
    private String authorImage; // Changed from authorimage
    private String date;
    private String tags;
    private String category;

    // One blog can have multiple sections
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section> sections;
}
