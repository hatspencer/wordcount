package com.erstegroup.hiring;

import java.io.File;

public class FileFactory {
    public File getFileFrom(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
