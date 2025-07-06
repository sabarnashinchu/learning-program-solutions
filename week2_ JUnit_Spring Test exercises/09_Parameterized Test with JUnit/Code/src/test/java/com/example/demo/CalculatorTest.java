package com.example.demo;

import com.example.demo.util.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "2, 4",
        "3, 9",
        "4, 16",
        "-1, 1",
        "0, 0"
    })
    void testSquare(int input, int expected) {
        assertEquals(expected, Calculator.square(input));
    }
}
