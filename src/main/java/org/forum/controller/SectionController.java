package org.forum.controller;

import org.forum.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.forum.service.SectionService;

import java.util.List;

@RestController
@RequestMapping("api/section")
public class SectionController extends AbstractController<Section> {
    @Autowired
    private SectionService service;

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Section>> getByName(@PathVariable String name) {
        List<Section> sections = service.readByName(name);
        if (sections.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(sections, headers, HttpStatus.OK);
    }

    @Override
    public SectionService getService() {
        return service;
    }
}
