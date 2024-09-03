package com.webinorbit.security.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository repository;

    public Blog save(BlogRequest request) {
        var book = Blog.builder()
                .title(request.getTitle())
                .image(request.getImage())
                .description(request.getDescription())
                .readtime(request.getReadtime())
                .author(request.getAuthor())
                .authorimage(request.getAuthorimage())
                .date(request.getDate())
                .tags(request.getTags())
                .category(request.getCategory())
                .section_content(request.getSection_content())
                .section_title(request.getSection_title())
                .build();
        return repository.save(book);
    }

    // Find all blogs
    public List<Blog> findAll() {
        return repository.findAll();
    }

    // Find a blog by ID
    public Blog findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found with id " + id));
    }


   // Update an existing blog
    public Blog update(Integer id, BlogRequest request) {
        Blog existingBlog = findById(id);
        existingBlog.setTitle(request.getTitle());
        existingBlog.setImage(request.getImage());
        existingBlog.setDescription(request.getDescription());
        existingBlog.setReadtime(request.getReadtime());
        existingBlog.setAuthor(request.getAuthor());
        existingBlog.setAuthorimage(request.getAuthorimage());
        existingBlog.setDate(request.getDate());
        existingBlog.setTags(request.getTags());
        existingBlog.setCategory(request.getCategory());
        existingBlog.setSection_title(request.getSection_title());
        existingBlog.setSection_content(request.getSection_content());
        return repository.save(existingBlog);
    }

    // Delete a blog by ID
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new BlogNotFoundException("Blog not found with id " + id);
        }
        repository.deleteById(id);
    }


}

