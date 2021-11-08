package com.bookservice;

import com.bookservice.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookserviceApplicationTests {
	@Autowired
	BookService bookService;
	@Test
	void contextLoads() {
		for(int i=0; i<10; i++){
			bookService.getBook(1L);
		}
	}

}
