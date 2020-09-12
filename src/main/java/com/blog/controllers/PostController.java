package com.blog.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.MyResponse;
import com.blog.dto.PostResponse;
import com.blog.model.Post;
import com.blog.services.PostService;

@RestController
public class PostController {
	@Autowired
	PostService postService;

	@GetMapping("/getblog")
	public ResponseEntity<MyResponse<List<PostResponse>>> getAllblog() {
		return new ResponseEntity<MyResponse<List<PostResponse>>>(
				new MyResponse<List<PostResponse>>(new Date(), "success", postService.getAllblog()),
				HttpStatus.CREATED);
	}

	@GetMapping("/getblog/{blogid}")
	public ResponseEntity<MyResponse<PostResponse>> getblog(@PathVariable("blogid") int id) {
		return new ResponseEntity<MyResponse<PostResponse>>(
				new MyResponse<PostResponse>(new Date(), "Success", postService.getBlogById(id)), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getblogbyid/{userid}")
	public ResponseEntity<MyResponse<List<PostResponse>>> getBlogByUserId(@PathVariable("userid") int userid) {
		return new ResponseEntity<MyResponse<List<PostResponse>>>(
				new MyResponse<List<PostResponse>>(new Date(), "Success", postService.getBlogByUserId(userid)),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delblog/{blogid}")
	public ResponseEntity<MyResponse<String>> deleteBook(@PathVariable("blogid") int id) {
		postService.deletePostByPostId(id);
		return new ResponseEntity<MyResponse<String>>(
				new MyResponse<String>(new Date(), "success", "The post for blog ID -" + id + " has been deleted"),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delblog")
	public ResponseEntity<MyResponse<String>> deleteBook() {
		postService.deleteAll();
		return new ResponseEntity<MyResponse<String>>(
				new MyResponse<String>(new Date(), "success", "All the post has been deleted"), HttpStatus.ACCEPTED);

	}

	// creating post mapping that post the model detail in the database
	@PostMapping("/createblog/{userid}")
	public ResponseEntity<MyResponse<PostResponse>> craeteBlog(@PathVariable("userid") int userId,
			@RequestBody Post post) {
		PostResponse createBlog = postService.createBlog(post, userId);
		return new ResponseEntity<MyResponse<PostResponse>>(
				new MyResponse<PostResponse>(new Date(), "success", createBlog), HttpStatus.ACCEPTED);
	}

	// creating put mapping that updates the blog detail
	@PutMapping("/updateblog/{id}")
	public ResponseEntity<MyResponse<PostResponse>> update(@PathVariable("id") int id, @RequestBody Post post) {
		return new ResponseEntity<MyResponse<PostResponse>>(
				new MyResponse<PostResponse>(new Date(), "success", postService.updateBlogbyId(id, post)),
				HttpStatus.ACCEPTED);
	}
}
