package com.example;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    void testPerformTaskCompletesWithinTimeout() {
        // ✅ Timeout: 1 second
        assertTimeout(Duration.ofSeconds(1), () -> {
            tester.performTask();
        });
    }
}
