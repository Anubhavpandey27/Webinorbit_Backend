package com.webinorbit.security.blog;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
    private  int readtime;
    private String author;
    private String authorimage;
    private String date;
    private String tags;
    private  String category;
    private String section_title;
    private String section_content;
}
