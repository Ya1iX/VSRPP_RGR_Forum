package org.forum.controller;

import org.forum.entity.Topic;
import org.forum.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.forum.service.TopicService;

import java.util.List;

@RestController
@RequestMapping("api/topic")
public class TopicController extends AbstractController<Topic> {
    @Autowired
    private TopicService service;

    @Autowired
    private SectionService sectionService;

    @Override
    public TopicService getService() {
        return service;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Topic>> getByName(@PathVariable String name) {
        List<Topic> topics = service.readByName(name);
        if (topics.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(topics, headers, HttpStatus.OK);
    }

    @GetMapping("/rating/{begin}-{end}")
    public ResponseEntity<List<Topic>> getByRating(@PathVariable int begin, @PathVariable int end) {
        List<Topic> topics = service.readByRating(begin, end);
        if (topics.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(topics, headers, HttpStatus.OK);
    }

    @GetMapping("/section/{sectionId}")
    public ResponseEntity<List<Topic>> getBySection(@PathVariable Long sectionId) {
        List<Topic> topics = service.readBySection(sectionService.read(sectionId));
        if (topics.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(topics, headers, HttpStatus.OK);
    }
}
