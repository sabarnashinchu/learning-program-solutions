package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionThrowerTest {

    ExceptionThrower thrower = new ExceptionThrower();

    @Test
    void testThrowsExceptionForNegativeNumber() {
        // ✅ This should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(-5);
        });
    }

    @Test
    void testNoExceptionForPositiveNumber() {
        // ✅ This should NOT throw any exception
        assertDoesNotThrow(() -> {
            thrower.throwException(10);
        });
    }
}
