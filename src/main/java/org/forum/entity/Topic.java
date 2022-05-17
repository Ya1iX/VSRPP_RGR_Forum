package org.forum.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_topics")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Topic extends AbstractEntity {
    @NotNull
    private String name;

    @NotNull
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", nullable = false)
    @JsonProperty("sectionId")
    private Section section;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    private Set<Message> messages;

    public Topic() {
    }

    public Topic(String name, int rating, Section section, Set<Message> messages) {
        this.name = name;
        this.rating = rating;
        this.section = section;
        this.messages = messages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @JsonGetter("sectionId")
    public Long getSectionId() {
        return section.getId();
    }

    @JsonGetter("messages")
    public int getMessagesSize() {
        return messages.size();
    }

    @Override
    public String toString() {
        return "[ID: " + id +
                ", name: " + name +
                ", rating: " + rating +
                ", section: " + section +
                ", messages: " + messages.size() + "]";
    }
}
