package com.blog.dto;

public class PostResponse {
    private int id;
    private String PostHeading;
    private String Descrition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostHeading() {
        return PostHeading;
    }

    public void setPostHeading(String postHeading) {
        PostHeading = postHeading;
    }

    public String getDescrition() {
        return Descrition;
    }

    public void setDescrition(String descrition) {
        Descrition = descrition;
    }
}
