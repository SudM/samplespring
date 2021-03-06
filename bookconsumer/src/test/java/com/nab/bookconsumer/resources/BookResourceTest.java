package com.nab.bookconsumer.resources;


import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.nab.bookconsumer.BookconsumerApplication;

//import com.in28minutes.springboot.StudentServicesApplication;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookconsumerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class BookResourceTest {

	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveStudentCourse() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/Books/1"),
				HttpMethod.GET, entity, String.class);
		
		System.out.println(response);

		String expected = "{id:Course1,name:Spring,description:10Steps}";

		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}

	