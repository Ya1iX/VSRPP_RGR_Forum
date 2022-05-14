package org.forum.repository;

import org.forum.entity.Section;
import org.forum.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByNameContaining(String name);
    List<Topic> findByRatingBetween(int begin, int end);
    List<Topic> findBySection(Section section);
}
