package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.model.Post;
import com.blog.model.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    
	@Modifying
	@Query("DELETE FROM Post p WHERE p.user=:userID")
    public int deletePostsByUserId(@Param("userID") User user);
}
