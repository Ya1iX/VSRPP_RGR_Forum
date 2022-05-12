package entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_messages")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Message extends AbstractEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date date;

    @Column(nullable = false, length = 1500)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User user;

    public Message() {
    }

    public Message(Date date, String text, Topic topic, User user) {
        this.date = date;
        this.text = text;
        this.topic = topic;
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "[ID: " + this.getId() +
                ", date: " + date +
                ", text: " + text +
                ", topic: " + topic.getName() +
                ", user: " + user.getUsername() + "]";
    }
}
