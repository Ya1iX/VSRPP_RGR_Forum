package org.forum.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_sections")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Section extends AbstractEntity {
    @NotNull
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
    private Set<Topic> topics;

    public Section() {
    }

    public Section(String name, Set<Topic> topics) {
        this.name = name;
        this.topics = topics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    @JsonGetter("topics")
    public int getTopicsSize() {
        return topics.size();
    }

    @Override
    public String toString() {
        return "[ID: " + id +
                ", name: " + name +
                ", topics: " + topics.size() +"]";
    }
}
