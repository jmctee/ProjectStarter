package com.jeklsoft.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestExample2 {
    @Test
    public void testEcho() throws Exception {
        assertEquals("test",new Example2().echo("test"));
    }
}
