package com.epam.project.task02.validator;

import com.epam.project.task02.exception.InvalidArgumentHandlerException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidatorTest {

    @DataProvider(name = "strings")
    private static Object[][] getTestStrings() {
        return new Object[][]{
                {"TRANSPORT_PLANE;    name24; 3000;   896;    1000;   25000", true},
                {"PASSENGER_PLANE;            2500;   900;    1325;   258", false},
                {"",false}

        };
    }
    @Test (dataProvider = "strings")
    public void testIsValidString(String string, boolean expected) {
        boolean actualResult = Validator.isValidString(string);
        Assert.assertEquals(actualResult, expected);
    }

    @Test
    public void testIsNotNullPositive() {
        Validator.isNotNull(new Object());
    }

    @Test (expectedExceptions = InvalidArgumentHandlerException.class)
    public void testIsNullArgumentThrowException() {
        Validator.isNotNull(null);
    }

    @Test
    public void testIsNotNullArgumentPositive() {
        Validator.isNotNull(new Object());
    }
}