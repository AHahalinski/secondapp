package com.epam.project.tas02.reader;

import com.epam.project.tas02.exception.ErrorCreateIOStreamHandlerException;
import com.epam.project.tas02.exception.FileNotExistHandlerException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {

    public static List<String> read(String path) throws FileNotExistHandlerException {

        File file = new File(path);

        if (file.exists() & file.isFile()) {
            String absolutePathPath = file.getAbsolutePath();
            Stream<String> lineStream = null;
            try {
                lineStream = Files.lines(Paths.get(absolutePathPath));
            } catch (IOException e) {
                throw new ErrorCreateIOStreamHandlerException(e);
            }

            return lineStream.collect(Collectors.toList());
        } else {
            throw new FileNotExistHandlerException("File not exist");
        }
    }
}