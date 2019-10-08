package com.epam.project.task02.factory;

import com.epam.project.task02.model.Plane;
import com.epam.project.task02.model.TransportPlane;

public class TransportPlaneFactory extends PlaneFactory {

    public Plane createPlane(String data) {
        TransportPlane transportPlane = new TransportPlane();

        int maxCargo = Integer.parseInt(data);
        transportPlane.setMaxCargo(maxCargo);

        return transportPlane;
    }
}
