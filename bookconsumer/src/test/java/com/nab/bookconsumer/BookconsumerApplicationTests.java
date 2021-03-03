package com.nab.bookconsumer;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.nab.bookconsumer.resources.BookResource;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class BookconsumerApplicationTests {
	@LocalServerPort
	private int port;
	
	//TestRestTemplate restTemplate = new TestRestTemplate();
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private BookServic controller;

	HttpHeaders headers = new HttpHeaders();
	@Test
	void contextLoads() throws JSONException {
		System.out.println("test");
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		String response = controller.getInfo("1");
		
		System.out.println(response);

		//String expected = "{id:Course1,name:Spring,description:10Steps}";

		//JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}

