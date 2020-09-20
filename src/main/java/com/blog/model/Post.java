package com.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
    @Id
    private int id;
    
    private String postHeading;
    
    private String description;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;
    
    private Date date = new Date();
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Post(Post post) {
    }

    public Post() {

    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPostHeading(String postHeading) {
        this.postHeading = postHeading;
    }

    public void setDescription(String descrition) {
        this.description = descrition;
    }

    public int getId() {
        return id;
    }

    public String getPostHeading() {
        return postHeading;
    }

    public String getDescription() {
        return description;
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
                ", PostHeading='" + postHeading + '\'' +
                ", Descrition='" + description + '\'' +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
