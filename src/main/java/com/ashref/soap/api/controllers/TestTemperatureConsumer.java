package com.ashref.soap.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashref.soap.api.services.TemperatureService;
import com.ashref.soap.api.temperature.MinTemperatureRequest;
import com.ashref.soap.api.temperature.MinTemperatureResponse;

@RestController
@RequestMapping("/test")
public class TestTemperatureConsumer {
	@Autowired
	private TemperatureService service;
	
	@PostMapping("/min")
	public MinTemperatureResponse testConsumeMin(@RequestBody MinTemperatureRequest request) {
		return service.consumeMin(request);
	}
}
