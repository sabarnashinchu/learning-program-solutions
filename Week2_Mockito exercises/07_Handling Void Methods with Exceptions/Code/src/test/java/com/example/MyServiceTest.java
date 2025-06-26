package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testDeleteUserThrowsException() {
        // Step 1: Create mock
        UserService mockUserService = Mockito.mock(UserService.class);

        // Step 2: Stub the void method to throw exception
        doThrow(new RuntimeException("User not found"))
            .when(mockUserService).deleteUser("123");

        // Step 3: Inject and call
        MyService service = new MyService(mockUserService);

        // Step 4: Assert that exception is thrown
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.removeUser("123");
        });

        assertEquals("User not found", exception.getMessage());

        // Step 5: Verify interaction
        verify(mockUserService).deleteUser("123");
    }
}
