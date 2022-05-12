package service.impl;

import entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import repository.TopicRepository;
import service.TopicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicRepository repository;

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