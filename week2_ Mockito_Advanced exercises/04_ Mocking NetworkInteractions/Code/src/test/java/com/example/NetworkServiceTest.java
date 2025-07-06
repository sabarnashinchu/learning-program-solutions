package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        // Step 1: Create mock client
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // Step 2: Stub connect() method
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // Step 3: Inject and call
        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();

        // Step 4: Validate result
        assertEquals("Connected to Mock Connection", result);
    }
}
