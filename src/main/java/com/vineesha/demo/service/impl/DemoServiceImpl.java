package com.vineesha.demo.service.impl;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vineesha.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
	
	@Value("${rest.template.url}")
	private String url;
	
	private final RestTemplate restTemplate;
	
	public DemoServiceImpl(RestTemplate restTemplateConfig) {
		this.restTemplate = restTemplateConfig;
	}

	@Override
	public ResponseEntity<JSONObject> getAllMoviesData() {
		logger.info("Starting method : getAllMoviesData in service impl");
		ResponseEntity<JSONObject> reponseObject = restTemplate.getForEntity(url, JSONObject.class);
		logger.info("Ending method : getAllMoviesData in service impl");
		return reponseObject;
	}

}
