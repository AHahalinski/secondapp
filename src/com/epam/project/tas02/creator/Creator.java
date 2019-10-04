package com.epam.project.tas02.creator;

import com.epam.project.tas02.exception.TypePlaneNotCorrectHandlerException;
import com.epam.project.tas02.model.PassengerPlane;
import com.epam.project.tas02.model.Plane;
import com.epam.project.tas02.model.PlaneType;
import com.epam.project.tas02.model.TransportPlane;

public class Creator {

    private static final String REGEX_SPLIT = ";\\s+";

    public static Plane getPlane(String data) {
        if (data == null) {
            return null;
        }

        String[] splitDataStrings = data.split(REGEX_SPLIT);
        String type = splitDataStrings[0];
        Plane planeCreated;
        PlaneType planeType = PlaneType.valueOf(type);

        switch (planeType) {

            case PASSENGER_PLANE:
                PassengerPlane passengerPlane = new PassengerPlane();
                passengerPlane.setType(planeType);
                passengerPlane.setBoardName(splitDataStrings[1]);
                int maxDistance = Integer.parseInt(splitDataStrings[2]);
                passengerPlane.setMaxDistance(maxDistance);
                int speed = Integer.parseInt(splitDataStrings[3]);
                passengerPlane.setSpeed(speed);
                int fuel = Integer.parseInt(splitDataStrings[4]);
                passengerPlane.setFuelConsumption(fuel);
                int maxPassengers = Integer.parseInt(splitDataStrings[5]);
                passengerPlane.setMaxPassengers(maxPassengers);
                planeCreated = passengerPlane;
                break;

            case TRANSPORT_PLANE:
                TransportPlane transportPlane = new TransportPlane();
                transportPlane.setType(planeType);
                transportPlane.setBoardName(splitDataStrings[1]);
                int maxDistanceTransport = Integer.parseInt(splitDataStrings[2]);
                transportPlane.setMaxDistance(maxDistanceTransport);
                int speedTransport = Integer.parseInt(splitDataStrings[3]);
                transportPlane.setSpeed(speedTransport);
                int fuelTransport = Integer.parseInt(splitDataStrings[4]);
                transportPlane.setFuelConsumption(fuelTransport);
                int maxCargo = Integer.parseInt(splitDataStrings[5]);
                transportPlane.setMaxCargo(maxCargo);
                planeCreated = transportPlane;
                break;

            default:
                throw new TypePlaneNotCorrectHandlerException("There isn't type of plane '" + type + "'");
        }
        return planeCreated;
    }
}
