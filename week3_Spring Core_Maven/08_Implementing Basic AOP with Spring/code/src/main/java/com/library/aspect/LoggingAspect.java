package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.BookService.addBook(..))")
    public void beforeAddBook() {
        System.out.println("[LOG] Before adding the book.");
    }

    @After("execution(* com.library.BookService.addBook(..))")
    public void afterAddBook() {
        System.out.println("[LOG] After adding the book.");
    }
}
