package com.epam.project.task02.validator;

import com.epam.project.task02.exception.InvalidArgumentHandlerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validator {

    private static final Logger LOGGER = LogManager.getLogger(Validator.class.getName());

    private static final String REGEX_VALID_STRING_DATA = "^(\\w+(;\\s+)){2}(\\d+(;\\s+|$)){4}";

    private Validator() {
    }

    public static boolean isValidString(String data) {
        LOGGER.debug("Check string");
        return data != null && data.matches(REGEX_VALID_STRING_DATA);
    }

    public static void isNotNull(Object o) {
        if (o == null) {
            LOGGER.error("Argument contains null", new InvalidArgumentHandlerException());
            throw new InvalidArgumentHandlerException("Argument contains null");
        }
    }
}
