package org.forum.service.impl;

import org.forum.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.forum.repository.SectionRepository;
import org.forum.service.SectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
