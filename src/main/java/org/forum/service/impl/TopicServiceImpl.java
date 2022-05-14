package org.forum.service.impl;

import org.forum.entity.Section;
import org.forum.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.forum.repository.TopicRepository;
import org.forum.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicRepository repository;

    @Override
    public List<Topic> readByName(String name) {
        return repository.findByNameContaining(name);
    }

    @Override
    public List<Topic> readByRating(int begin, int end) {
        return repository.findByRatingBetween(begin, end);
    }

    @Override
    public List<Topic> readBySection(Section section) {
        return repository.findBySection(section);
    }

    @Override
    public Topic read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Topic> read() {
        return repository.findAll();
    }

    @Override
    public void save(Topic entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Topic entity) {
        Topic topic = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        topic.setRating(entity.getRating());
        topic.setMessages(entity.getMessages());
        topic.setName(entity.getName());
        topic.setSection(entity.getSection());
        repository.save(topic);
    }
}
