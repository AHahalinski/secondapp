package com.epam.project.task02.validator;


public class Validator {

    private static final String REGEX = "^(\\w+(;\\s+)){2}(\\d+(;\\s+|$)){4}";

    public static boolean isValid(String data) {
               return data != null && data.matches(REGEX);
    }
}
