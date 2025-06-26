package com.example;

public class ExceptionThrower {

    public void throwException(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        // Else: no exception
        System.out.println("Number is: " + number);
    }
}
