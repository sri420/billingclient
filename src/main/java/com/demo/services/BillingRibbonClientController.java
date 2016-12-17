package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BillingRibbonClientController {

	@Autowired
	RestTemplate loadBalancedRestTemplate;
	
	
	
	//Using Load Balanced RestTemplate_Ribbon_NO_EUREKA_DirectAccess
	@GetMapping("/api/v1/billingribbonclient/{id}/{id2}")
	public String getMessageWithNon_Load_BalancedRestTemplate_Ribbon(@PathVariable String id,@PathVariable String id2){
		ResponseEntity<String> response=loadBalancedRestTemplate.exchange("http://billing-service/api/billing/message/{id}/{id2}",HttpMethod.GET,null,String.class,id,id2);
		return response.getBody().toString();
	}

}
