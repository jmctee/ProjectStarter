package com.jeklsoft.example;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class FileReader {
    private final File inputFile;
    private final LineIterator it;

    public FileReader(String filename) throws IOException {
        inputFile = new File(filename);
        it = FileUtils.lineIterator(inputFile, "UTF-8");
    }

    public Boolean eof() {
        return !it.hasNext();
    }

    public String getLine() throws NoSuchElementException {
        return it.next().toString();
    }

    public void close() {
        it.close();
    }
}
