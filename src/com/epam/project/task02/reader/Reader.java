package com.epam.project.task02.reader;

import com.epam.project.task02.exception.ErrorCreateIOStreamHandlerException;
import com.epam.project.task02.exception.FileNotExistHandlerException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {

    private Reader() {
    }

    public static List<String> read(String path) {
        File file = new File(path);

        if (!file.exists() || !file.isFile()) {
            throw new FileNotExistHandlerException("File" + file.getAbsolutePath() + " not exist");
        }

        String absolutePathPath = file.getAbsolutePath();
        Stream<String> lineStream;
        try {
            lineStream = Files.lines(Paths.get(absolutePathPath));
        } catch (IOException e) {
            throw new ErrorCreateIOStreamHandlerException(e);
        }

        return lineStream.collect(Collectors.toList());

    }
}