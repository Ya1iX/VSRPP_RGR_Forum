package controller;

import entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MessageService;
import service.Service;

@RestController
@RequestMapping("api/message")
public class MessageController extends AbstractController<Message> {
    @Autowired
    private MessageService service;

    @Override
    public Service<Message> getService() {
        return service;
    }
}
