package com.jeklsoft.example

import org.junit.Test

import static org.junit.Assert.assertEquals;

class TestExample {
  @Test
  public void testEcho() {
    assertEquals("test",new Example().echo("test"))
  }
}
