package com.epam.project.task02.validator;

import com.epam.project.task02.exception.InvalidArgumentHandlerException;
import com.epam.project.task02.exception.ObjectNotExistHandlerException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidatorTest {

    private static final Validator VALIDATOR = new Validator();

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
        boolean actualResult = VALIDATOR.isValidString(string);
        Assert.assertEquals(actualResult, expected);
    }

    @Test(expectedExceptions = ObjectNotExistHandlerException.class)
    public void testIsNotNullThrowException() {
        VALIDATOR.isNotNull(null, new Object());
    }

    @Test
    public void testIsNotNullPositive() {
        VALIDATOR.isNotNull(new Object(), new Object());
    }

    @Test (expectedExceptions = InvalidArgumentHandlerException.class)
    public void testIsNullArgumentThrowException() {
        VALIDATOR.isNotNullArgument(null);
    }

    @Test
    public void testIsNotNullArgumentPositive() {
        VALIDATOR.isNotNullArgument(new Object());
    }
}