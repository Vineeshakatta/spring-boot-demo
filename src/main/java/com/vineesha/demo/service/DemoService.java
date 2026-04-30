package com.vineesha.demo.service;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;

public interface DemoService {

	ResponseEntity<JSONObject> getAllMoviesData();

}
