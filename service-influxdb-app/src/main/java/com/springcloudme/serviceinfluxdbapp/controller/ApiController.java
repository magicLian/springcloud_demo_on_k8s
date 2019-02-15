package com.springcloudme.serviceinfluxdbapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ApiController {

	@RequestMapping("/me")
	public String me(){
		return "aaaaaaaaa";
	}
}
