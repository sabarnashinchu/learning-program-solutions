package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {
        // Step 1: Create mock repository
        Repository mockRepository = mock(Repository.class);

        // Step 2: Stub getData() to return mock data
        when(mockRepository.getData()).thenReturn("Mock Data");

        // Step 3: Inject mock and call processData()
        Service service = new Service(mockRepository);
        String result = service.processData();

        // Step 4: Assert output
        assertEquals("Processed Mock Data", result);
    }
}
