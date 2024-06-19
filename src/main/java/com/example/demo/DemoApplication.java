package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(BookRepository repository) {
		return (args) -> {
			// Preload some data
			repository.save(new Book("Book Title 1", "Author 1"));
			repository.save(new Book("Book Title 2", "Author 2"));
			repository.save(new Book("Book Title 3", "Author 3"));
			repository.save(new Book("Book Title 4", "Author 4"));
			repository.save(new Book("Book Title 5", "Author 5"));
		};
	}
}
