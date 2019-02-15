package com.springcloudme.serviceinfluxdbapp.controller;

import com.springcloudme.serviceinfluxdbapp.utils.InfluxDBUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/influxdb")
public class InfluxdbController {


	@RequestMapping("/queryUI")
	public ModelAndView queryUI(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("query");
		return mav;
	}

	@RequestMapping("/query")
	public Object query(@RequestParam String sql){
		InfluxDBUtils utils= InfluxDBUtils.getInfluxDBUtil();
		return utils.exec(utils.getInstance(),sql);
	}
}
