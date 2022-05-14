package org.forum.repository;

import org.forum.entity.Message;
import org.forum.entity.Topic;
import org.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByTextContaining(String text);
    List<Message> findByUser(User user);
    List<Message> findByTopic(Topic topic);
}
