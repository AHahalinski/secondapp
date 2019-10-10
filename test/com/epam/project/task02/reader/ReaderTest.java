package com.epam.project.task02.reader;

import com.epam.project.task02.exception.FileNotExistHandlerException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ReaderTest {

    private static final String PATH_FILE_DATA = "test/resources/dataPlaneTest.txt";
    private static final String PATH_EMPTY_FILE = "test/resources/empty.txt";
    private static final String PATH_NOT_FILE = "test/resources/empty";

    @Test
    public void testReadPositive() {
        List<String> strings = Reader.read(PATH_FILE_DATA);
        int actualResult = strings.size();
        int expectedResult = 4;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testReadEmptyFile() {
        List<String> strings = Reader.read(PATH_EMPTY_FILE);
        int actualResult = strings.size();
        int expectedResult = 0;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(expectedExceptions = FileNotExistHandlerException.class)
    public void testReadEmptyFileThrowException() {
        List<String> strings = Reader.read(PATH_NOT_FILE);
    }
}