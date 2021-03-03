package com.nab.bookconsumer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nab.bookconsumer.service.BookService;
/*
 * This is a Rest Controller class which accepts the user request and
 * invokes the service class to communicate with actual third party API.
 * The response received from the third party api get sent as a string 
 * to the requester. 
 */
@RestController
@RequestMapping("/bookauthor")
public class BookResource {

	@Autowired
	BookService bookservice;

	@RequestMapping("/{Id}")
	public String getInfo(@PathVariable("Id") String Id) {
		return bookservice.getInfo(Id);

	}

}