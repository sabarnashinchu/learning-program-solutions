package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathTest {

    Calculator calc = new Calculator();

    @Test
    void testAddition() {
        assertEquals(5, calc.add(2, 3));
    }
}
