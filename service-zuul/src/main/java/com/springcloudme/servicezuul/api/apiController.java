package com.springcloudme.servicezuul.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class apiController {

	@RequestMapping("/aaa")
	public String get(){
		return "aaaaa";
	}
}
