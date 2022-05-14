package org.forum.service;

import org.forum.entity.Section;
import org.forum.entity.Topic;

import java.util.List;

public interface TopicService extends Service<Topic> {
    List<Topic> readByName(String name);
    List<Topic> readByRating(int begin, int end);
    List<Topic> readBySection(Section section);
}
