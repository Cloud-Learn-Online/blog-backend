package com.blog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.PostResponse;
import com.blog.exceptions.BlogNotFoundException;
import com.blog.exceptions.UserNotFoundException;
import com.blog.helper.PostHelper;
import com.blog.model.Post;
import com.blog.model.User;
import com.blog.repository.PostRepo;
import com.blog.repository.UserRepo;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    public List<PostResponse> getAllblog() {
        if(postRepo==null)
            throw new BlogNotFoundException("Blog does not exist");
        List<Post> post= postRepo.findAll();
        return PostHelper.getAllPost(post);
    }

    public PostResponse getBlogById(int id) {
        Optional<Post> post=postRepo.findById(id);
        if(!post.isPresent())
            throw new BlogNotFoundException("Blog not found "+id);
        Post post1= post.get();
        return PostHelper.getPostResponse(post1);
    }
    
    public List<PostResponse> getBlogByUserId(int userid) {
        List<PostResponse> postList=new ArrayList<>();
        Optional<User> userOptional= userRepo.findById(userid);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User does not exist, user ID - "+userid);
        User user1=userOptional.get();
        for (Post posts:user1.getUserblogs()) {
            postList.add(PostHelper.getPostResponse(posts));
        }
        if(postList.isEmpty())
            throw new BlogNotFoundException("Blog does not exist for the user ID -"+userid);
        return postList;
    }

    @Transactional
    public PostResponse createBlog(Post post, int id) {
        Optional<User> userTemp = userRepo.findById(id);
        if (userTemp.isPresent()) {
            User gotUser = userTemp.get();
            post.setUser(gotUser);
            Post postDetails = postRepo.save(post);
            return PostHelper.getPostResponse(postDetails);

        }
        return null;
    }

    @Transactional
    public PostResponse updateBlogbyId(int id, Post post) {
        Optional<Post> postOptional=postRepo.findById(id);
        if(!postOptional.isPresent())
            throw new BlogNotFoundException("Blog does not exist");
        Post post1 = postOptional.get();
        post1.setId(post.getId());
        post1.setDescription(post.getDescription());
        post1.setPostHeading(post.getPostHeading());
        final Post post2=postRepo.save(post1);
        return PostHelper.getPostResponse(post2);
    }

    @Transactional
    public void deletePostByPostId(int id) {
        Optional<Post> post=postRepo.findById(id);
        if(!post.isPresent())
            throw new BlogNotFoundException("Blog does not exist - "+id);
        postRepo.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        if(postRepo==null)
            throw new BlogNotFoundException("Blog does not exist");
        postRepo.deleteAll();
    }

    public int deletePostsByUserId(User user){
        return postRepo.deletePostsByUserId(user);
    }


}
