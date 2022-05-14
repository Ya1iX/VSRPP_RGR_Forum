package org.forum.service;

import org.forum.entity.Section;

import java.util.List;

public interface SectionService extends Service<Section> {
    List<Section> readByName(String name);
}
