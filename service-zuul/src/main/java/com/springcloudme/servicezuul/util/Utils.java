package com.springcloudme.servicezuul.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Utils {

	@Autowired
	private Environment env;

	public String getProps(String key){
		return env.getProperty(key);
	}
}
