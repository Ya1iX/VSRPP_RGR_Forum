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
        return repository.findById(id).get();
    }

    @Override
    public List<Section> read() {
        return repository.findAll();
    }

    @Override
    public void save(Section entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Section entity) {
        Section section = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        section.setName(entity.getName());
        section.setTopics(entity.getTopics());
        repository.save(section);
    }
}
