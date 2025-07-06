package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        // Step 1: Mock REST client
        RestClient mockRestClient = mock(RestClient.class);

        // Step 2: Stub getResponse() method
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // Step 3: Inject mock and test
        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();

        // Step 4: Assert result
        assertEquals("Fetched Mock Response", result);
    }
}
