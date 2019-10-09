package com.epam.project.task02.loader;

import com.epam.project.task02.exception.InvalidArgumentHandlerException;
import com.epam.project.task02.model.Plane;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoaderTest {

    private static final Loader LOADER = new Loader();

    private static final String PATH_FILE_DATA = "test/resources/dataPlaneTest.txt";
    private static final String PATH_EMPTY_FILE = "test/resources/empty.txt";
    private static final String PATH_NOT_FILE = "test/resources/empty";

    @Test
    public void testLoadDataPositive() {
        List<Plane> planes = LOADER.loadData(PATH_FILE_DATA);
        int expectedResult = 3;
        int actualResult = planes.size();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(expectedExceptions = InvalidArgumentHandlerException.class)
    public void testLoadDataEmptyFileThrowException() {
        List<Plane> planes = LOADER.loadData(null);
    }
}