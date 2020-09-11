package com.blog.repository;

import com.blog.model.Post;

import com.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
   @Query("DELETE FROM Post p WHERE p.user=:userID")
    public int deletePostsByUserId(@Param("userID") User user);
}
