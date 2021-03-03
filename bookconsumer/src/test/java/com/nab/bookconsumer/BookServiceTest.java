package com.nab.bookconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.platform.runner.JUnitPlatform;
import com.nab.bookconsumer.service.BookService;

//@RunWith(JUnit4.class)
@RunWith(JUnitPlatform.class)
public class BookServiceTest {
	
	@Autowired
	BookService bookservice;
	
	@Test(expected = NullPointerException.class)
	public void whenExceptionThrown_thenExpectationSatisfied() {
	    String test = bookservice.getInfo("1");
	    test.length();
	}

}
