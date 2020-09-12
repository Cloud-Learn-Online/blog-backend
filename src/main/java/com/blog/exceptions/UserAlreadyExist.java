package com.blog.exceptions;

public class UserAlreadyExist extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExist(String s){
        super(s);
    }
}
