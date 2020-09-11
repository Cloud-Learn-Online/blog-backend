package com.blog.helper;

import com.blog.dto.PostResponse;
import com.blog.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostHelper {
    public static PostResponse getPostResponse(Post post) {
        PostResponse postResponse = new PostResponse();
        postResponse.setId(post.getId());
        postResponse.setPostHeading(post.getPostHeading());
        postResponse.setDescrition(post.getDescrition());
        return postResponse;
    }

    public static List<PostResponse> getAllPost(List<Post> post) {
        List<PostResponse> responseList = new ArrayList<>();
        for (Post posts : post) {
            responseList.add(getPostResponse(posts));
        }
        return responseList;
    }


}
