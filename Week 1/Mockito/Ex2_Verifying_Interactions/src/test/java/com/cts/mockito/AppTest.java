package com.cts.mockito;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class AppTest {

    @Test
    public void testVerifyInteraction() {

        NotificationService service =
                mock(NotificationService.class);

        service.sendNotification("Hello");

        verify(service).sendNotification("Hello");
    }
}