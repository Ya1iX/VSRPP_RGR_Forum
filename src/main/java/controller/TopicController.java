package controller;

import entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Service;
import service.TopicService;

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
