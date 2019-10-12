package com.epam.project.task02.factory;

import com.epam.project.task02.model.PassengerPlane;
import com.epam.project.task02.model.Plane;
import com.epam.project.task02.parser.Parser;

public class PassengerPlaneFactory extends PlaneFactory {

    public Plane createPlane(String data) {
        PassengerPlane passengerPlane = new PassengerPlane();

        int maxPassengers = Parser.getIntValue(data);
        passengerPlane.setMaxPassengers(maxPassengers);
        return passengerPlane;
    }
}
