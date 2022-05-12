package org.forum.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class User extends AbstractEntity {
    @Column(nullable = false, length = 30)
    private String username;

    @NotNull
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Message> messages;

    @Column(name = "authority")
    private String authority;

    @Column(name = "mail")
    private String mail;

    public User() {
    }

    public User(String username, String password, Set<Message> messages, String authority, String mail) {
        this.username = username;
        this.password = password;
        this.messages = messages;
        this.authority = authority;
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "[ID: " + this.getId() +
                ", username: " + username +
                ", messages: " + messages.size() + "]";
    }
}
