package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Service;
import service.UserService;

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
