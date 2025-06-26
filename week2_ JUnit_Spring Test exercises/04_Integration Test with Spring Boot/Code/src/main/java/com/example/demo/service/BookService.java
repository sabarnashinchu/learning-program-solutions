package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book save(Book b) { return repo.save(b); }
    public List<Book> findAll() { return repo.findAll(); }
    public Book findById(Long id) { return repo.findById(id).orElse(null); }
}
