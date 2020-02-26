package com.ashref.soap.api.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.ashref.soap.api.temperature.MinTemperatureRequest;
import com.ashref.soap.api.temperature.MinTemperatureResponse;

@Service
public class TemplateService {
	@Autowired
	private Jaxb2Marshaller marshaller;
	private WebServiceTemplate template;
	private final String URL = "http://localhost:8081/api";
	
	@PostConstruct
	public void init() {
		template = new WebServiceTemplate(marshaller);
	}
	
	public MinTemperatureResponse consumeMin(MinTemperatureRequest request) {
		return (MinTemperatureResponse) template.marshalSendAndReceive(URL, request);
	}
}