package com.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.model.Post;
import com.blog.services.PostService;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/blog")
	private List<Post> getAllblog(Post model)
	{
		return postService.getAllblog(model);
	}

	/*
	 * @GetMapping("/blog/{blogid}") private Model getblog(@PathVariable("id") int
	 * id) { return postService.getId(id); }
	 */  
	
	@DeleteMapping("/book/{bookid}")  
	private void deleteBook(@PathVariable("bookid") int id)   
	{  
	postService.delete(id);  
	}  
	//creating post mapping that post the model detail in the database  
	@PostMapping("/post/create")  
	public Post craeteBlog(@RequestBody Post model)   
	{  
	Post createBlog=postService.createBlog(model);  
	return createBlog;  
	}  
	//creating put mapping that updates the blog detail   
	@PutMapping("/books")  
	private Post update(@RequestBody Post model)   
	{  
	postService.saveOrUpdate(model);  
	return model;  
	}  
	
}
