package service.impl;

import entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import repository.SectionRepository;
import service.SectionService;

import java.util.List;

public class SectionServiceImpl implements SectionService {
    @Autowired
    private SectionRepository repository;

    @Override
    public Section read(Long id) {
        return null;
    }

    @Override
    public List<Section> read() {
        return null;
    }

    @Override
    public void save(Section entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void edit(Section entity) {

    }
}
