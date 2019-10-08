package com.epam.project.task02.creator;

import com.epam.project.task02.exception.TypePlaneNotCorrectHandlerException;
import com.epam.project.task02.factory.PassengerPlaneFactory;
import com.epam.project.task02.factory.PlaneFactory;
import com.epam.project.task02.factory.TransportPlaneFactory;
import com.epam.project.task02.model.Plane;
import com.epam.project.task02.model.PlaneType;
import com.epam.project.task02.validator.Validator;

public class Creator {

    private static final String REGEX_SPLIT = ";\\s+";

    public Plane getPlane(String data) {
        Validator.isNullArgument(data);

        String[] splitDataStrings = data.split(REGEX_SPLIT);
        String type = splitDataStrings[0];

        PlaneType planeType = PlaneType.valueOf(type);

        PlaneFactory planeFactory;

        switch (planeType) {
            case PASSENGER_PLANE:
                planeFactory = new PassengerPlaneFactory();
                break;
            case TRANSPORT_PLANE:
                planeFactory = new TransportPlaneFactory();
                break;
            default:
                throw new TypePlaneNotCorrectHandlerException("There isn't type of plane '" + type + "'");
        }

        return planeFactory.getPlane(splitDataStrings);
    }
}
