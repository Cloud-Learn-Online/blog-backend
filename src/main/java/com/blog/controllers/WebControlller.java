package com.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebControlller {
	
	@GetMapping("/")
	public String homepage() { 
		return "index";
	}
	
	@GetMapping("/login")
	public String login() { 
		return "log";
	}
}
