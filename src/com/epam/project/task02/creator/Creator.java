package com.epam.project.task02.creator;

import com.epam.project.task02.exception.TypePlaneNotCorrectHandlerException;
import com.epam.project.task02.factory.PassengerPlaneFactory;
import com.epam.project.task02.factory.PlaneFactory;
import com.epam.project.task02.factory.TransportPlaneFactory;
import com.epam.project.task02.model.Plane;
import com.epam.project.task02.model.PlaneType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Creator {

    private static Logger logger = LogManager.getLogger(Creator.class.getName());
    private static final String REGEX_SPLIT = ";\\s+";

    public Plane createPlane(String data) {
        logger.debug(String.format("start creating plane (%s)", data));

        String[] splitDataStrings = data.split(REGEX_SPLIT);
        String type = splitDataStrings[0];

        PlaneType planeType;
        try {
            planeType = PlaneType.valueOf(type);
        } catch (IllegalArgumentException e) {
            logger.error(String.format("%sof plane isn't correct", type), e);
            throw new TypePlaneNotCorrectHandlerException(type + "of plane isn't correct", e);
        }

        PlaneFactory planeFactory = null;

        switch (planeType) {
            case PASSENGER_PLANE:
                return new PassengerPlaneFactory().getPlane(splitDataStrings);
            case TRANSPORT_PLANE:
                planeFactory = new TransportPlaneFactory();
                break;
        }
        logger.debug("end creating plane");

        return planeFactory.getPlane(splitDataStrings);
    }
}
