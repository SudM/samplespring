package com.nab.bookconsumer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nab.bookconsumer.service.BookService;

@RestController
@RequestMapping("/Books")
public class BookResource {

	@Autowired
   BookService bookservice;

   
    @RequestMapping("/{bookId}")
    public String getInfo(@PathVariable("bookId") String Id) {
    	 return bookservice.getInfo(Id);

    }

}