package com.jeklsoft.example

import static org.junit.Assert.assertEquals

import org.junit.Test
import static com.jeklsoft.util.PropertyReader.readPropertiesFromResourceFile

class TestPropertyReader {

  @Test
  public void testSimpleRead() {
    def propertyMap = readPropertiesFromResourceFile('simple.properties')

    assertEquals(3,propertyMap.size())

    assertEquals('1', propertyMap.get('a'))
    assertEquals('2', propertyMap.get('b'))
    assertEquals('3', propertyMap.get('c'))
  }
}
