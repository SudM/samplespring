package com.nab.bookconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


@Service
public class BookService {
	// @Autowired
	 private RestTemplate restTemplate = null;
	 
	 @Value("${api.url}")
	    private String apiUrl;

	 public String getInfo(String Id) {
	    	String response =  restTemplate.getForObject(apiUrl, String.class );
	        return response;

	    }
	
}
