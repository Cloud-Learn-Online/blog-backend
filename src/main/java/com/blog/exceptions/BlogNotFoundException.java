package com.blog.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BlogNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public BlogNotFoundException(String s) {
        super(s);
    }
}
