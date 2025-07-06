package com.library;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void saveBook(String bookName) {
        System.out.println("Book '" + bookName + "' saved to repository.");
    }
}
