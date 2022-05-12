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
        return null;
    }

    @Override
    public List<Topic> read() {
        return null;
    }

    @Override
    public void save(Topic entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void edit(Topic entity) {

    }
}
