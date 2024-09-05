package com.webinorbit.security.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository repository;
    private final BlogRepository blogRepository;
    private final SectionRepository sectionRepository;

    public Blog save(BlogRequest request) {
        var book = Blog.builder()
                .title(request.getTitle())
                .image(request.getImage())
                .description(request.getDescription())
                .readTime(request.getReadTime() != null ? request.getReadTime() : 0)
                .author(request.getAuthor())
                .authorImage(request.getAuthorImage())
                .date(request.getDate())
                .tags(request.getTags())
                .category(request.getCategory())

                .build();
        return repository.save(book);
    }

    // Find all blogs
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    // Find a blog by ID
    public Blog findById(Integer id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog", id));
    }


   // Update an existing blog
    public Blog update(Integer id, BlogRequest request) {
        Blog existingBlog = findById(id);
        existingBlog.setTitle(request.getTitle());
        existingBlog.setImage(request.getImage());
        existingBlog.setDescription(request.getDescription());
        existingBlog.setReadTime(request.getReadTime());
        existingBlog.setAuthor(request.getAuthor());
        existingBlog.setAuthorImage(request.getAuthorImage());
        existingBlog.setDate(request.getDate());
        existingBlog.setTags(request.getTags());
        existingBlog.setCategory(request.getCategory());
        return repository.save(existingBlog);
    }

    // Delete a blog by ID
    public void deleteById(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Blog" , id);
        }
        repository.deleteById(id);
    }

    public Section addSectionToBlog(int blogId, SectionRequest request) {
        Blog blog = findById(blogId);
        Section section = Section.builder()
                .sectionTitle(request.getSectionTitle())
                .sectionContent(request.getSectionContent())
                .blog(blog)
                .build();
        return sectionRepository.save(section);
    }

    public List<Section> findSectionsByBlogId(int blogId) {
        return sectionRepository.findByBlogId(blogId);
    }

    public Section updateSection(int sectionId, SectionRequest request) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new ResourceNotFoundException("Section", sectionId));
        section.setSectionTitle(request.getSectionTitle());
        section.setSectionTitle(request.getSectionContent());
        return sectionRepository.save(section);
    }

    public void deleteSection(int sectionId) {
        sectionRepository.deleteById(sectionId);
    }


}

