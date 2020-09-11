package com.blog.services;

import com.blog.dto.PostResponse;
import com.blog.dto.UserResponse;
import com.blog.exceptions.BlogNotFoundException;
import com.blog.exceptions.UserAlreadyExist;
import com.blog.exceptions.UserNotFoundException;
import com.blog.helper.PostHelper;
import com.blog.helper.UserHelper;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    PostService postService;

    public List<UserResponse> getAllUsers() {
        if(userRepo==null)
            throw new UserNotFoundException("User does not exist");
        List<User> userList=userRepo.findAll();
        return UserHelper.getAllUsers(userList);

    }

    public UserResponse getUserById(int userId) {
        Optional<User> user=userRepo.findById(userId);
        if(!user.isPresent())
            throw new UserNotFoundException("User id -" + userId+" doesn't exist");
        User userResponse= user.get();
        return UserHelper.getUserById(userResponse);
    }

    public User createUser(User user) {
        Optional<User> users=userRepo.findById(user.getUserId());
        if(users.isPresent())
            throw new UserAlreadyExist("User already exists");
        User userDetails=userRepo.save(user);
        System.out.println("userDetails"+userDetails);
        return userDetails;
    }



    public UserResponse updateUserById(int userId, User userDetails) {
        Optional<User> user=userRepo.findById(userId);
        if(!user.isPresent())
            throw new UserNotFoundException("User id -" + userId+" doesn't exist");
        User user1= user.get();
        user1.setUserId(userDetails.getUserId());
        user1.setUserName(userDetails.getUserName());
        user1.setPhoneNumber(userDetails.getPhoneNumber());
        user1.setUserDetails(userDetails.getUserDetails());
        user1.setUserblogs(userDetails.getUserblogs());
        final User updatedUser = userRepo.save(user1);
        return UserHelper.getUserById(updatedUser);
    }

    public void deleteUserById(int userId) {
        Optional<User> user=userRepo.findById(userId);
        if(!user.isPresent())
            throw new UserNotFoundException("User does not exist");
        if(!user.get().getUserblogs().isEmpty()) {// postService.deletePostsByUserId(user.get());
            User user1 = user.get();
            for (Post posts : user1.getUserblogs())
            {
                postService.deletePostByPostId(posts.getId());
            }
        }
        userRepo.deleteById(userId);
    }

}
