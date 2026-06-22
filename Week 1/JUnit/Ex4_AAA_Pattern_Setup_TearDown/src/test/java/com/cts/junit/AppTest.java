package com.cts.junit;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

    private App app;

    @Before
    public void setUp() {
        app = new App();
        System.out.println("Before Test");
    }

    @After
    public void tearDown() {
        System.out.println("After Test");
    }

    @Test
    public void testAdd() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = app.add(a, b);

        // Assert
        assertEquals(30, result);
    }
}