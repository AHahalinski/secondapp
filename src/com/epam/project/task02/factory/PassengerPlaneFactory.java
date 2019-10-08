package com.epam.project.task02.factory;

import com.epam.project.task02.model.PassengerPlane;
import com.epam.project.task02.model.Plane;

public class PassengerPlaneFactory extends PlaneFactory {

    public Plane createPlane(String data) {
        PassengerPlane passengerPlane = new PassengerPlane();

        int maxPassengers = Integer.parseInt(data);
        passengerPlane.setMaxPassengers(maxPassengers);

        return passengerPlane;
    }
}
