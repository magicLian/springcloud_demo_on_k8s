package com.springcloudme.serviceinfluxdbapp.controller;

import com.springcloudme.serviceinfluxdbapp.utils.InfluxDBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/influxdb")
public class InfluxdbController {

	private static Logger log = LoggerFactory.getLogger(InfluxdbController.class);

	@RequestMapping("/queryUI")
	public ModelAndView queryUI(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("query");
		return mav;
	}

	@RequestMapping("/query")
	public Object query(@RequestParam String sql){
		log.info("in /influxdb/query");
		InfluxDBUtils utils= InfluxDBUtils.getInfluxDBUtil();
		return utils.query(utils.getInstance(),sql);
	}

	@RequestMapping("/insert")
	public Object insert(){
		log.info("in /influxdb/query");
		InfluxDBUtils utils= InfluxDBUtils.getInfluxDBUtil();
		return utils.insert(utils.getInstance());
	}
}
