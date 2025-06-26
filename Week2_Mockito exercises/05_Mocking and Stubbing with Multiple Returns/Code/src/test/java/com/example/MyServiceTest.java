package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testMultipleReturnValues() {
        // Step 1: Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Stub multiple returns
        when(mockApi.getStatus())
            .thenReturn("Pending")
            .thenReturn("Processing")
            .thenReturn("Completed");

        // Step 3: Test
        MyService service = new MyService(mockApi);
        String[] result = service.checkStatusMultipleTimes();

        // Step 4: Assertions
        assertEquals("Pending", result[0]);
        assertEquals("Processing", result[1]);
        assertEquals("Completed", result[2]);
    }
}
