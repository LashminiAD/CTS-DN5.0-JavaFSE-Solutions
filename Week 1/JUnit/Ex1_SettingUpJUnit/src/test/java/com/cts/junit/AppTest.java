package com.cts.junit;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testAddition() {

        App app = new App();

        int result = app.add(2, 3);

        assertEquals(5, result);
    }
}