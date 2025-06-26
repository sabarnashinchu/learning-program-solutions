package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // ✅ Assert that two values are equal
        assertEquals(5, 2 + 3, "2 + 3 should be equal to 5");

        // ✅ Assert that condition is true
        assertTrue(5 > 3, "5 is greater than 3");

        // ✅ Assert that condition is false
        assertFalse(5 < 3, "5 is not less than 3");

        // ✅ Assert that value is null
        assertNull(null, "Value should be null");

        // ✅ Assert that value is not null
        assertNotNull(new Object(), "Object should not be null");
    }
}
