package com.jeklsoft.util

class PropertyReader {

  public static Properties readPropertiesFromResourceFile(String propertyFileName) {
    InputStream is = getClass().getResourceAsStream("/${propertyFileName}");
    Properties properties = new Properties()
    properties.load(is)
    properties
  }
}
