package com.blog.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Post;

@Service
public class PostService {

	@Autowired  
	
	private List<Post> blogs=new ArrayList<>();
	
	public Post createBlog(Post model) {
		blogs.add(model);
		return model;
	}
	

	public void saveOrUpdate(Post model) {
		//Implement update API
		//this will update a post which is having a particular ID
		
	}

	public List<Post> getAllblog(Post model) {
		return this.blogs;
	}
	

	public void delete(int id) {
		// Implement delete API
		//for this particular ID you have to find and delete it from the existing blogs
		
	}

	/*
	 * public Model getId(int id) { // TODO Auto-generated method stub return null;
	 * }
	 */

}
