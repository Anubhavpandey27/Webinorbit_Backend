package com.webinorbit.security.blog;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService service;
    // Create a new blog post
    @PostMapping("/create")
    public ResponseEntity<Blog> createBlog(@Valid @RequestBody BlogRequest request) {
        Blog createdBlog = service.save(request);
        return ResponseEntity.ok(createdBlog);
    }

    // Get all blog posts
    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = service.findAll();
        return ResponseEntity.ok(blogs);
    }

    // Get a blog post by ID
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Integer id) {
        Blog blog = service.findById(id);
        return ResponseEntity.ok(blog);
    }

    // Update an existing blog post
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(
            @PathVariable Integer id,
            @Valid @RequestBody BlogRequest request) {
        Blog updatedBlog = service.update(id, request);
        return ResponseEntity.ok(updatedBlog);
    }

    // Delete a blog post by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    // Add a section to a blog post
    @PostMapping("/{id}/sections")
    public ResponseEntity<Section> addSectionToBlog(
            @PathVariable Integer id,
            @RequestBody SectionRequest request) {
        Section section = service.addSectionToBlog(id, request);
        return ResponseEntity.ok(section);
    }

    // Get all sections of a blog post
    @GetMapping("/{id}/sections")
    public ResponseEntity<List<Section>> getSectionsByBlogId(@PathVariable Integer id) {
        List<Section> sections = service.findSectionsByBlogId(id);
        return ResponseEntity.ok(sections);
    }

    // Update a section of a blog post
    @PutMapping("/sections/{sectionId}")
    public ResponseEntity<Section> updateSection(
            @PathVariable Integer sectionId,
            @RequestBody SectionRequest request) {
        Section section = service.updateSection(sectionId, request);
        return ResponseEntity.ok(section);
    }

    // Delete a section of a blog post
    @DeleteMapping("/sections/{sectionId}")
    public ResponseEntity<Void> deleteSection(@PathVariable Integer sectionId) {
        service.deleteSection(sectionId);
        return ResponseEntity.noContent().build();
    }

}
