package com.jeklsoft.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

public class TestFileReader {
    private static String fileName;

    @BeforeClass
    public static void setup() throws IOException {
        File testFile = File.createTempFile("temp-file-name", ".tmp");
        FileUtils.writeLines(testFile, Arrays.asList("line 1", "line 2", "line 3"));
        fileName = testFile.getAbsolutePath();
    }

    @Test
    public void testFileRead() throws IOException {
        FileReader reader = new FileReader(fileName);

        assertFalse(reader.eof());

        assertEquals("line 1", reader.getLine());
        assertEquals("line 2", reader.getLine());
        assertEquals("line 3", reader.getLine());

        assertTrue(reader.eof());
    }
}
