package com.example;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        // Step 1: Create mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Call method with argument
        MyService service = new MyService(mockApi);
        service.process();

        // Step 3: Verify the argument passed to method
        verify(mockApi).sendMessage(eq("Hello Mockito!"));
    }
}
