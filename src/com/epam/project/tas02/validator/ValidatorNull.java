package com.epam.project.tas02.validator;

import com.epam.project.tas02.exception.ObjectNotExistHandlerException;

public class ValidatorNull {

    public static boolean isNotNull(Object o1, Object o2) throws ObjectNotExistHandlerException {

        if (o1 == null || o2 == null) {
            throw new ObjectNotExistHandlerException("Argument are null: " + o1 + " " + o2);
        }
        return true;
    }
}
