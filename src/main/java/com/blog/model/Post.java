package com.blog.model;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    private int id;
    private String PostHeading;
    private String Descrition;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Post(Post post) {
    }

    public Post() {

    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPostHeading(String postHeading) {
        PostHeading = postHeading;
    }

    public void setDescrition(String descrition) {
        Descrition = descrition;
    }

    public int getId() {
        return id;
    }

    public String getPostHeading() {
        return PostHeading;
    }

    public String getDescrition() {
        return Descrition;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
