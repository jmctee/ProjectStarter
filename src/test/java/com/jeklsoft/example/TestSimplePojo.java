package com.jeklsoft.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestSimplePojo {
    @Test
    public void testToString() {
        assertEquals("Sam,29", new SimplePojo("Sam", 29).toString());
    }

    @Test
    public void testEquals() {
        SimplePojo sj1 = new SimplePojo("Sally", 27);
        SimplePojo sj2 = new SimplePojo("Sally", 27);
        assertTrue(sj1.equals(sj2));
    }

    @Test
    public void testHashcode() {
        int hash1 = new SimplePojo("Sally", 27).hashCode();
        int hash2 = new SimplePojo("Sally", 27).hashCode();
        assertTrue(hash1 == hash2);
    }
}
