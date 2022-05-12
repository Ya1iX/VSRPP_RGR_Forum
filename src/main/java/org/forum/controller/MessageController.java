package org.forum.controller;

import org.forum.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.forum.service.MessageService;

@RestController
@RequestMapping("api/message")
public class MessageController extends AbstractController<Message> {
    @Autowired
    private MessageService service;

    @Override
    public MessageService getService() {
        return service;
    }
}
