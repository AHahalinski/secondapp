package com.epam.project.task02.reader;

import com.epam.project.task02.exception.ErrorCreateIOStreamHandlerException;
import com.epam.project.task02.exception.FileNotExistHandlerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {

    private static Logger logger = LogManager.getLogger(Reader.class.getName());

    public List<String> read(String path) {
        logger.info("Start reading dataFile");
        File file = new File(path);

        if (!file.exists() || !file.isFile()) {
            logger.error(String.format("%s no exist", file.getName()), new FileNotExistHandlerException());
            throw new FileNotExistHandlerException("File" + file.getAbsolutePath() + " not exist");
        }

        String absolutePathPath = file.getAbsolutePath();
        List<String> listData;

        try (Stream<String> lineStream = Files.lines(Paths.get(absolutePathPath))) {
            listData = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error create IOStream", e);
            throw new ErrorCreateIOStreamHandlerException(e);
        }

        logger.info("File was read successful");
        return listData;

    }
}