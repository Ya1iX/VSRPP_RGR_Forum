package org.forum.service;

import org.forum.entity.Message;
import org.forum.entity.Topic;
import org.forum.entity.User;

import java.util.List;

public interface MessageService extends Service<Message> {
    List<Message> readByText(String text);
    List<Message> readByUser(User user);
    List<Message> readByTopic(Topic topic);
}
