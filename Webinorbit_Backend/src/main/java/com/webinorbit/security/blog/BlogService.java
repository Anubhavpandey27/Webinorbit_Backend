package com.webinorbit.security.blog;

import com.webinorbit.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository repository;

    public void save(BlogRequest request) {
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
        repository.save(book);

        // Send a notification to the user (assuming you have a way to get the user)
//        User user = getUserFromRequest(request);  // You need to implement this method to fetch the user
//        if (user != null) {
//            notificationService.createNotification("New blog post created: " + blog.getTitle(), user);
//        }
    }

    public List<Blog> findAll() {
        return repository.findAll();
    }
    public Blog findById(int id){
        Blog ans = new Blog();
        List<Blog> All=findAll();
        for (Blog blog : All) {
            if (blog.getId() == id) {
                ans=blog;
                return blog;
            }
        }
        return ans;
    }

}
