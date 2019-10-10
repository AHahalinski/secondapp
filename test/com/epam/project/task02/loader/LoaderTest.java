package com.epam.project.task02.loader;

import com.epam.project.task02.exception.InvalidArgumentHandlerException;
import com.epam.project.task02.model.Plane;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoaderTest {

    private static final String PATH_FILE_DATA = "test/resources/dataPlaneTest.txt";

    @Test
    public void testLoadDataPositive() {
        List<Plane> planes = Loader.loadData(PATH_FILE_DATA);
        int expectedResult = 3;
        int actualResult = planes.size();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(expectedExceptions = InvalidArgumentHandlerException.class)
    public void testLoadDataEmptyFileThrowException() {
        List<Plane> planes = Loader.loadData(null);
    }
}