package com.library.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.library.entity.Book;
public interface BookRepository extends JpaRepository<Book, Long> {
}