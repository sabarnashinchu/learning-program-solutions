package com.example;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testInteractionOrder() {
        // Step 1: Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Call methods in specific order
        MyService service = new MyService(mockApi);
        service.performOperation();

        // Step 3: Verify the order
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).connect();
        inOrder.verify(mockApi).fetchData();
        inOrder.verify(mockApi).disconnect();
    }
}
