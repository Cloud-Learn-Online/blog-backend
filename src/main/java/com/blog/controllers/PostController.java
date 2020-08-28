package com.blog.controllers;

import com.blog.model.Post;
import com.blog.model.User;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/getblog")
    public List<Post> getAllblog(Post post)
    {
        return postService.getAllblog(post);
    }

     @GetMapping("/getblog/{blogid}")
     public Post getblog(@PathVariable("blogid") int id)
     {
         return postService.getBlogById(id);
     }

    @DeleteMapping("/delblog/{bookid}")
    public void deleteBook(@PathVariable("bookid") int id)
    {
        postService.delete(id);
    }

    @DeleteMapping("/delblog")
    public void deleteBook()
    {
        postService.deleteAll();
    }
    //creating post mapping that post the model detail in the database
    @PostMapping("/createblog")
    public Post craeteBlog(@RequestBody Post post)
    {
        Post createBlog=postService.createBlog(post);
        return createBlog;
    }
    //creating put mapping that updates the blog detail
    @PutMapping("/updateblog")
    public Post  update(@RequestBody Post model)
    {
                postService.update(model);
        return model;
    }

}


