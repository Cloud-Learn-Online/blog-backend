package com.blog.controllers;

import com.blog.model.User;
import com.blog.repository.UserRepo;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userid}")
    public User getUserById(@PathVariable("userid") int userId){
        return userService.getUserById(userId);
    }
    @PostMapping("/createUser")
    public User createUser(@RequestBody User users){
        User userCreated=userService.createUser(users);
        return userCreated;
    }

    @PutMapping("/updateuser/{userid}")
    public User updateUser(@PathVariable("userid")  int userId, @RequestBody User userDetails)
    //throws ResourceNotFoundException
    {
        User userUpdated= userService.updateUserById(userId,userDetails);
        return userUpdated;
    }

    @DeleteMapping("/delUser/{userid}")
    public void deleteUser(@PathVariable("userid") int userId ){
        userService.deleteUserById(userId);

    }
}
