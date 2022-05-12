package service.impl;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<User> read() {
        return repository.findAll();
    }

    @Override
    public void save(User entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(User entity) {
        User user = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        user.setMail(entity.getMail());
        user.setAuthority(entity.getAuthority());
        user.setMessages(entity.getMessages());
        user.setUsername(entity.getUsername());
        user.setPassword(entity.getPassword());
        repository.save(user);
    }
}