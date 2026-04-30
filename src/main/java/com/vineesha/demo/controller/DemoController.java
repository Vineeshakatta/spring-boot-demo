package com.vineesha.demo.controller;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vineesha.demo.service.DemoService;

@RestController
@RequestMapping("/demo/v1")
public class DemoController {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	private final DemoService demoService;
	
	public DemoController(DemoService demoService) {
		this.demoService = demoService;
	}
	
	@GetMapping("/movies")
	public ResponseEntity<JSONObject> getAllMoviesData() {
		logger.info("Starting method : getAllMoviesData in controller");
		return demoService.getAllMoviesData();
	}

}
