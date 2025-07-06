package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorAaaTest {

    private Calculator calculator;

    // ✅ Setup method: runs before each test
    @BeforeEach
    void setUp() {
        calculator = new Calculator();  // Arrange
        System.out.println("Setup completed");
    }

    // ✅ Teardown method: runs after each test
    @AfterEach
    void tearDown() {
        System.out.println("Teardown completed");
    }

    @Test
    void testAddition() {
        // Arrange done in setUp()

        // Act
        int result = calculator.add(10, 5);

        // Assert
        assertEquals(15, result);
    }

    @Test
    void testSubtraction() {
        // Act
        int result = calculator.subtract(10, 5);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void testDivision() {
        // Act
        int result = calculator.divide(20, 4);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void testDivideByZeroThrowsException() {
        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}
