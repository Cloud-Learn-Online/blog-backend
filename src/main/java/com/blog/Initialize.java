package com.blog;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blog.model.Post;
import com.blog.model.User;
import com.blog.services.PostService;
import com.blog.services.UserService;

/**
 * This Class is implemented to create some data set when
 * the application boots up
 * 
 * Interface {@link CommandLineRunner} has a method run()
 * which we have to override so that when application boots up
 * it executes this method.
 */

@Component
public class Initialize implements CommandLineRunner {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public void run(String... args) throws Exception {
	
		// Creating 5 Users
		for(int i =1;i<=5;i++) {
			userService.createUser(getUserObject(i));
			createPostsForAUser(i);
		}
		
	}
	
	/**
	 * Creates Posts for a particular userId
	 * @param userId
	 */
	private void createPostsForAUser(int userId) {

		/* Here for a particular User, 5 blogs/post will be created
		 * eg : User with a userId 2;
		 * So it will have 5 blogs/posts with the following ids
		 *  postId 21
		 *  postId 22
		 *  postId 23
		 *  postId 24
		 *  postId 25
		 */
		int i = (userId * 10) + 1;
		int j = (userId * 10) + 5;

		for (; i <= j; i++)
			postService.createBlog(getPostObject(i), userId);
	}

	/**
	 * Creates a User object with a given Id
	 * @param userId
	 * @return
	 */
	private User getUserObject(int userId) {
		User user  = new User();
		user.setUserId(userId);
		user.setUserName("User "+userId);
		user.setUserDetails("This is user details for user "+ userId);
		user.setPhoneNumber(1234567890);
		//Notice I have not set the user.setUserblogs(userblogs) as its not required.
		return user;
	}
	
	/**
	 * Creates a Post object for a particular User with an ID
	 * @param postId
	 * @param user
	 * @return
	 */
	private Post getPostObject(int postId) {
		Post p = new Post();
		p.setId(postId);
		p.setPostHeading("Post Heading "+postId);
		p.setDate(new Date());
		p.setDescription("This is a Post Description "+postId);
		return p; 
	}
}
