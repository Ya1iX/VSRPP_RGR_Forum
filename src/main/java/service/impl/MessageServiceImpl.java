package service.impl;

import entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import repository.MessageRepository;
import service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository repository;

    @Override
    public Message read(Long id) {
        return null;
    }

    @Override
    public List<Message> read() {
        return null;
    }

    @Override
    public void save(Message entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void edit(Message entity) {

    }
}
