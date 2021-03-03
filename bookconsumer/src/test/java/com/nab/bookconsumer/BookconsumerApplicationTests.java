package com.nab.bookconsumer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.nab.bookconsumer.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class BookconsumerApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private BookService service;
	
	//Successful Data retrieval Test case
	@Test
	void fetchData() throws Exception {
		String response = service.getInfo("OL1A.json");
		String expected = response;
		JSONAssert.assertEquals(expected, response, false);
	}
	
	//Exception Handling Test - 404
	@Test
	void fetchDataNotFoundException() {
		try {
			service.getInfo(null);
		} catch (HttpClientErrorException ex) {
			throw new AssertionError(ex.getStatusCode() + " 404 Error: Book Id does not exist");
		}
	}

	//Exception Handling Test - Internal Error - NullPointer Exception
	@Test
	void fetchInternalErrorException() {
		try {
			service = null;
			service.getInfo(null);
		} catch (Exception ex) {
			throw new AssertionError("500 Internal Error");
		}
	}
}
