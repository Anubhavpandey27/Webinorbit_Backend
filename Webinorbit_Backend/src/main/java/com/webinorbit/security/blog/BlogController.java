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
    @PostMapping
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

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody BlogRequest request
    ) {
        service.save(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Blog>> findAllBooks() {
        return ResponseEntity.ok(service.findAll());
    }




}
