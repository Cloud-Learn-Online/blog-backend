package com.blog.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="posts")
public class Post {
    @Id
    private int id;
    private String PostHeading;
    private String Descrition;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date = new Date();

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

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", PostHeading='" + PostHeading + '\'' +
                ", Descrition='" + Descrition + '\'' +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
