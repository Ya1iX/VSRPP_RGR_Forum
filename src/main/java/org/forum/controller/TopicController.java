package org.forum.controller;

import org.forum.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.forum.service.Service;
import org.forum.service.TopicService;

@RestController
@RequestMapping("api/topic")
public class TopicController extends AbstractController<Topic> {
    @Autowired
    private TopicService service;

    @Override
    public Service<Topic> getService() {
        return service;
    }
}
