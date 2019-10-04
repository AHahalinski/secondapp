package com.epam.project.task02.factory;

import com.epam.project.task02.model.Plane;
import com.epam.project.task02.model.TransportPlane;

public class TransportPlaneFactory extends PlaneFactory {

    public Plane createPlane(String[] data) {
        TransportPlane transportPlane = (TransportPlane) createSimplePlane(new TransportPlane(), data);

        int maxCargo = Integer.parseInt(data[5]);
        transportPlane.setMaxCargo(maxCargo);

        return transportPlane;
    }
}
