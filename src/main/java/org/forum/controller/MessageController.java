package org.forum.controller;

import org.forum.entity.Message;
import org.forum.entity.Topic;
import org.forum.entity.User;
import org.forum.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/message")
public class MessageController extends AbstractController<Message> {
    @Autowired
    private MessageService service;

    @Override
    public MessageService getService() {
        return service;
    }

    @GetMapping("/text/{text}")
    public ResponseEntity<List<Message>> getByText(@PathVariable String text) {
        List<Message> messages = service.readByText(text);
        if (messages.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(messages, headers, HttpStatus.OK);
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<Message>> getByUser(@PathVariable User user) {
        List<Message> messages = service.readByUser(user);
        if (messages.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(messages, headers, HttpStatus.OK);
    }

    @GetMapping("/topic/{topic}")
    public ResponseEntity<List<Message>> getByTopic(@PathVariable Topic topic) {
        List<Message> messages = service.readByTopic(topic);
        if (messages.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(messages, headers, HttpStatus.OK);
    }
}
