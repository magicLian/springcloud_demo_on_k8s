package com.springcloudme.servicetp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ApiController {

	@RequestMapping(value = "/me",method = RequestMethod.GET)
	public String  getUser(){
		return "hjashdahsdha";
	}
}
