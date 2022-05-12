package org.forum.controller;

import org.forum.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.forum.service.Service;
import org.forum.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController extends AbstractController<User> {
    @Autowired
    private UserService service;

    @Override
    public Service<User> getService() {
        return service;
    }
}
