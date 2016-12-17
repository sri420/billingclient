package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BillingClientController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/api/billingclient/{id}/{id2}")
	public String getMessage(@PathVariable String id,@PathVariable String id2){
		ResponseEntity<String> response=restTemplate.exchange("http://billing/api/billing/message/{id}/{id2}",HttpMethod.GET,null,String.class,id,id2);
		return response.getBody().toString();
	}
}
