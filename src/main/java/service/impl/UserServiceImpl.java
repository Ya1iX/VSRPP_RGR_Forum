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
        return null;
    }

    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void edit(User entity) {

    }
}
