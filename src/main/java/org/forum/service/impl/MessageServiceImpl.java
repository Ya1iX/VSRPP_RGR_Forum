package org.forum.service.impl;

import org.forum.entity.Message;
import org.forum.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.forum.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository repository;

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
