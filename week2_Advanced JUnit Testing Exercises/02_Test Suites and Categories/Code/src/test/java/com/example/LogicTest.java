package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    Calculator calc = new Calculator();

    @Test
    void testPositiveCheck() {
        assertTrue(calc.isPositive(10));
    }
}
