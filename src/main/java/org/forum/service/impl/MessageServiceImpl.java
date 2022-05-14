package org.forum.service.impl;

import org.forum.entity.Message;
import org.forum.entity.Topic;
import org.forum.entity.User;
import org.forum.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.forum.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository repository;

    @Override
    public List<Message> readByText(String text) {
        return repository.findByTextContaining(text);
    }

    @Override
    public List<Message> readByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public List<Message> readByTopic(Topic topic) {
        return repository.findByTopic(topic);
    }

    @Override
    public Message read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Message> read() {
        return repository.findAll();
    }

    @Override
    public void save(Message entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Message entity) {
        Message message = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        message.setDate(entity.getDate());
        message.setText(entity.getText());
        message.setTopic(entity.getTopic());
        message.setUser(entity.getUser());
        repository.save(message);
    }
}
