package controller;

import entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.SectionService;
import service.Service;

@RestController
@RequestMapping("api/section")
public class SectionController extends AbstractController<Section> {
    @Autowired
    private SectionService service;

    @Override
    public Service<Section> getService() {
        return service;
    }
}
