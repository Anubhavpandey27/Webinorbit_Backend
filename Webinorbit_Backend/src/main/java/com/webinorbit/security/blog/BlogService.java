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
                .read_time(request.getRead_time() != null ? request.getRead_time() : 0)
                .author(request.getAuthor())
                .author_image(request.getAuthor_image())
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
        existingBlog.setRead_time(request.getRead_time());
        existingBlog.setAuthor(request.getAuthor());
        existingBlog.setAuthor_image(request.getAuthor_image());
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
                .section_title(request.getSection_title())
                .section_content(request.getSection_content())
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
        section.setSection_title(request.getSection_title());
        section.setSection_content(request.getSection_content());
        return sectionRepository.save(section);
    }

    public void deleteSection(int sectionId) {
        sectionRepository.deleteById(sectionId);
    }


}