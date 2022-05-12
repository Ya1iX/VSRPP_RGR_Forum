package org.forum.controller;

import org.forum.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.forum.service.SectionService;

@RestController
@RequestMapping("api/section")
public class SectionController extends AbstractController<Section> {
    @Autowired
    private SectionService service;

    @Override
    public SectionService getService() {
        return service;
    }
}
