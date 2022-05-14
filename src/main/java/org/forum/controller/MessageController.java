package org.forum.controller;

import org.forum.entity.Message;
import org.forum.service.TopicService;
import org.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.forum.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("api/message")
public class MessageController extends AbstractController<Message> {
    @Autowired
    private MessageService service;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicService topicService;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Message>> getByUser(@PathVariable Long userId) {
        List<Message> messages = service.readByUser(userService.read(userId));
        if (messages.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(messages, headers, HttpStatus.OK);
    }

    @GetMapping("/topic/{topicId}")
    public ResponseEntity<List<Message>> getByTopic(@PathVariable Long topicId) {
        List<Message> messages = service.readByTopic(topicService.read(topicId));
        if (messages.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(messages, headers, HttpStatus.OK);
    }
}
