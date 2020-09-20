package com.blog.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.blog.dto.MyResponse;
import com.blog.exceptions.BlogNotFoundException;
import com.blog.exceptions.UserAlreadyExist;
import com.blog.exceptions.UserNotFoundException;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<MyResponse<String>> userNotFoundException(UserNotFoundException userNotFoundException) {
		return new ResponseEntity<MyResponse<String>>(
				new MyResponse<String>(new Date(), "failed", userNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = BlogNotFoundException.class)
	public ResponseEntity<MyResponse<String>> blogNotFoundException(BlogNotFoundException blogNotFoundException) {
		MyResponse<String> myResponse = new MyResponse<String>(new Date(), "failed",
				blogNotFoundException.getMessage());
		return new ResponseEntity<MyResponse<String>>(myResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UserAlreadyExist.class)
	public ResponseEntity<MyResponse<String>> UserAlreadyExist(UserAlreadyExist userAlreadyExist) {
		MyResponse<String> myResponse = new MyResponse<String>(new Date(), "failed", userAlreadyExist.getMessage());
		return new ResponseEntity<MyResponse<String>>(myResponse, HttpStatus.NOT_FOUND);
	}
}
