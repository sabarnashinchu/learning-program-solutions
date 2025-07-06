package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Calculator1Test {

    Calculator1 calc = new Calculator1();

    @Test
    void testAdd() {
        assertEquals(7, calc.add(3, 4));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calc.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, calc.multiply(5, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calc.divide(10, 5));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(8, 0);
        });
    }
}
