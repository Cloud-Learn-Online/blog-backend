package com.blog.controllers;

import com.blog.dto.MyResponse;
import com.blog.dto.UserResponse;
import com.blog.exceptions.UserNotFoundException;
import com.blog.model.User;
import com.blog.repository.UserRepo;
import com.blog.services.UserService;
import jdk.internal.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/users")
    public ResponseEntity<MyResponse<List<UserResponse>>> getAllUsers(){
        MyResponse myResponse=new MyResponse(new Date(),"success",userService.getAllUsers());
        return new ResponseEntity<MyResponse<List<UserResponse>>>(myResponse, HttpStatus.OK);
    }

    @GetMapping("/users/{userid}")
    public ResponseEntity<MyResponse<UserResponse>> getUserById(@PathVariable("userid") int userId){
       MyResponse myResponse=new MyResponse(new Date(),"success",userService.getUserById((userId)));
        return new ResponseEntity<MyResponse<UserResponse>>(myResponse, HttpStatus.OK);
    }


    @PostMapping("/createUser")
    public ResponseEntity<MyResponse<User>> createUser(@RequestBody User users)
    {
        User userCreated=userService.createUser(users);
        MyResponse myResponse=new MyResponse(new Date(),"success", userCreated);
        return new ResponseEntity<MyResponse<User>>(myResponse,HttpStatus.CREATED);
    }

    @PutMapping("/updateuser/{userid}")
        public ResponseEntity<MyResponse<UserResponse>> updateUser(@PathVariable("userid")  int userId, @RequestBody User userDetails){
        return new ResponseEntity<MyResponse<UserResponse>>(new MyResponse(new Date(),"success",userService.updateUserById(userId,userDetails)),HttpStatus.CREATED);
    }


    @DeleteMapping("/deluser/{userid}")
    public ResponseEntity<MyResponse<String>> deleteUser(@PathVariable("userid") int userId ){
        userService.deleteUserById(userId);
        return new ResponseEntity<MyResponse<String>>(new MyResponse(new Date(),"success","The user has been deleted successfully"),HttpStatus.CREATED);
    }

}
