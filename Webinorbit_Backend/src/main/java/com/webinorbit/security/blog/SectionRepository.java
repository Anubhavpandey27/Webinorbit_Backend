package com.webinorbit.security.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {
    List<Section> findByBlogId(Integer blogId);
}
