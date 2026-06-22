package com.cts.mockito;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AppTest {

    @Test
    public void testMockingAndStubbing() {

        // Create Mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stubbing
        when(mockApi.getData()).thenReturn("Mock Data");

        // Assertion
        assertEquals("Mock Data", mockApi.getData());
    }
}