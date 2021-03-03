package com.nab.bookconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * The Springboot service class which invokes the open library to fetch the
 * author details.
 */
@Service
public class BookService {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.url}")
	private String apiUrl;
	//Get the Author Info from Open library
	public String getInfo(String Id) {
		String response = restTemplate.getForObject(apiUrl + Id, String.class);
		return response;

	}

}
