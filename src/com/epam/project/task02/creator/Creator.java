package com.epam.project.task02.creator;

import com.epam.project.task02.exception.TypePlaneNotCorrectHandlerException;
import com.epam.project.task02.factory.PassengerPlaneFactory;
import com.epam.project.task02.factory.PlaneFactory;
import com.epam.project.task02.factory.TransportPlaneFactory;
import com.epam.project.task02.model.Plane;
import com.epam.project.task02.model.PlaneType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Creator {

    private static Logger logger = LogManager.getLogger(Creator.class.getName());

    public Plane createPlane(String[] stringsData) {
        logger.debug(String.format("start creating plane (%s)", Arrays.toString(stringsData)));
        String type = stringsData[0];
        PlaneType planeType;

        try {
            planeType = PlaneType.valueOf(type);
        } catch (IllegalArgumentException e) {
            logger.error(String.format("%s of plane isn't correct", type), e);
            throw new TypePlaneNotCorrectHandlerException(type + "of plane isn't correct", e);
        }
        PlaneFactory planeFactory = null;

        switch (planeType) {
            case PASSENGER_PLANE:
                planeFactory = new PassengerPlaneFactory();
                break;
            case TRANSPORT_PLANE:
                planeFactory = new TransportPlaneFactory();
                break;
        }
        logger.debug("end creating plane");
        return planeFactory.getPlane(stringsData);
    }
}
