package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // ✅ Define test execution order
public class OrderedTests {

    @Test
    @Order(1)
    void testA() {
        System.out.println("Running testA");
        assertEquals(10, 5 + 5);
    }

    @Test
    @Order(3)
    void testC() {
        System.out.println("Running testC");
        assertTrue(3 < 5);
    }

    @Test
    @Order(2)
    void testB() {
        System.out.println("Running testB");
        assertNotNull("JUnit");
    }
}
