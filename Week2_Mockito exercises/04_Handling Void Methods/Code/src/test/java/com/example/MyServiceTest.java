package com.example;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVoidMethod() {
        // Step 1: Create mock
        LoggerService mockLogger = Mockito.mock(LoggerService.class);

        // Step 2: Stub the void method (optional here because it does nothing)
        doNothing().when(mockLogger).log(anyString());

        // Step 3: Use service and verify
        MyService service = new MyService(mockLogger);
        service.doSomethingImportant();

        // Step 4: Verify void method was called
        verify(mockLogger).log("Important action done!");
    }
}
