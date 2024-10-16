package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void testHelloWorld() {
        String expected = "Hello, World!";
        String actual = "Hello, World!";
        assertEquals(expected, actual);
    }

    @Test
    public void testFail() {
//        fail();
    }
}