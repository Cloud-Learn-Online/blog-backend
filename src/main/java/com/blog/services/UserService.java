package com.blog.services;

import com.blog.model.Post;
import com.blog.model.User;
import com.blog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        return userRepo.findAll();

    }

    public User getUserById(int userId) {
        //Optional<User> user=userRepo.findById(userId);
//        if(!user.isPresent())
//            throws new StudentNotFoundException("id-" + id)
        return userRepo.findById(userId).get();
    }

    public User createUser(User user) {
        User userDetails=userRepo.save(user);
        System.out.println("userDetails"+userDetails);
        return userDetails;
    }

    public User updateUserById(int userId, User userDetails) {
//        userRepo.save(user);
//        userRepo.findById(userId);
        //.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        User user=new User();
        user.setUserId(userDetails.getUserId());
        user.setUserName(userDetails.getUserName());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        user.setUserDetails(userDetails.getUserDetails());
        user.setUserblogs(userDetails.getUserblogs());
        final User updatedUser = userRepo.save(user);
        return updatedUser;
    }

    public void deleteUserById(int userId) {
        userRepo.deleteById(userId);
    }
}
