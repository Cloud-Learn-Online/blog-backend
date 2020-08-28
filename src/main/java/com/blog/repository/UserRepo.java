package com.blog.repository;

import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    User findByUserId(int id);
}
