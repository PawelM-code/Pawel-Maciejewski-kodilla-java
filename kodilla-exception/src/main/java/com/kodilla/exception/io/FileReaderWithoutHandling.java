package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;

public class FileReaderWithoutHandling {
    public void readFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
    }
}
