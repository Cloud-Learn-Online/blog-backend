package com.blog.helper;

import com.blog.dto.UserResponse;
import com.blog.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserHelper {
    public static UserResponse getUserById(User user) {
        UserResponse userResponse=new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setUserDetails(user.getUserDetails());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setUserName(user.getUserName());
        return userResponse;
    }

    public static List<UserResponse> getAllUsers(List<User> userList) {
        List<UserResponse> userResponseList=new ArrayList<>();
        for (User users:userList) {
            userResponseList.add(getUserById(users));
        }
        return userResponseList;
    }
}
