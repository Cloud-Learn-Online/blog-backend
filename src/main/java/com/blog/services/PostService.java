package com.blog.services;

import com.blog.model.Post;
import com.blog.model.User;
import com.blog.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    public List<Post> getAllblog(Post model) {
        return postRepo.findAll();
     }

    public Post createBlog(Post post) {
        Post postDetails=postRepo.save(post);
        return postDetails;
    }

    public void update(Post post) {
        Post toBeUpdatedPost=new Post();
        toBeUpdatedPost.setId(post.getId());
        toBeUpdatedPost.setDescrition(post.getDescrition());
        toBeUpdatedPost.setPostHeading(post.getPostHeading());
        toBeUpdatedPost.setUser(post.getUser());
    }

    public Post getBlogById(int id) {
        return postRepo.findById(id).get();
    }

    public void delete(int id) {
        postRepo.deleteById(id);
    }

    public void deleteAll() {
        postRepo.deleteAll();
    }


    /*
     * public Model getId(int id) { // TODO Auto-generated method stub return null;
     * }
     */
}
