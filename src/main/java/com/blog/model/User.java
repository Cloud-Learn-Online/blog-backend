package com.blog.model;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    private int userId;
    private String userName;
    private String userDetails;
    private int phoneNumber;
    @OneToMany(mappedBy = "user")
    private List<Post> userblogs =new ArrayList<Post>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(String userDetails) {
        this.userDetails = userDetails;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Post> getUserblogs() {
        return userblogs;
    }

    public void setUserblogs(List<Post> userblogs) {
        this.userblogs = userblogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userDetails='" + userDetails + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", userblogs=" + userblogs +
                '}';
    }
}
