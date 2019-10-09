package com.epam.project.task02.validator;

import com.epam.project.task02.exception.InvalidArgumentHandlerException;
import com.epam.project.task02.exception.ObjectNotExistHandlerException;

public class Validator {

    private static final String REGEX_VALID_STRING_DATA = "^(\\w+(;\\s+)){2}(\\d+(;\\s+|$)){4}";

    public static boolean isValidString(String data) {
               return data != null && data.matches(REGEX_VALID_STRING_DATA);
    }

    public static void isNotNull(Object o1, Object o2) {
        if (o1 == null || o2 == null) {
            throw new ObjectNotExistHandlerException("Arguments are null: " + o1 + " " + o2);
        }
    }

    public static void isNotNullArgument(Object ob){
        if (ob == null) {
            throw new InvalidArgumentHandlerException("Argument is null");
        }
    }
}
