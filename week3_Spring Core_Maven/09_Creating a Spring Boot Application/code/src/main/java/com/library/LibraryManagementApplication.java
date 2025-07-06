package com.library;
import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class LibraryManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }
 @Bean
    public CommandLineRunner loadData(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("The Alchemist", "Paulo Coelho"));
            bookRepository.save(new Book("1984", "George Orwell"));
            bookRepository.save(new Book("Clean Code", "Robert C. Martin"));
        };
    }
}