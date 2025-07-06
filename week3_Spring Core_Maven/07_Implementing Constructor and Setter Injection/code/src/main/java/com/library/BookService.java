package com.library;

public class BookService {
    private BookRepository bookRepository;
    private String serviceName;

    // Constructor
    public BookService(String serviceName) {
        this.serviceName = serviceName;
    }

    // Setter
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        System.out.println("[" + serviceName + "] Adding book: " + bookName);
        bookRepository.saveBook(bookName);
    }
}
