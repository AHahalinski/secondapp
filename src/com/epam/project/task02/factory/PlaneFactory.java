package com.epam.project.task02.factory;

import com.epam.project.task02.model.Plane;
import com.epam.project.task02.model.PlaneType;

public abstract class PlaneFactory {

    final Plane createSimplePlane(Plane plane, String[] stringData) {
        if (stringData == null || plane == null) {
            return null;
        }

        String type = stringData[0];
        PlaneType planeType = PlaneType.valueOf(type);
        plane.setType(planeType);

        plane.setBoardName(stringData[1]);

        int maxDistance = Integer.parseInt(stringData[2]);
        plane.setMaxDistance(maxDistance);

        int speed = Integer.parseInt(stringData[3]);
        plane.setSpeed(speed);

        int fuel = Integer.parseInt(stringData[4]);
        plane.setFuelConsumption(fuel);

        return plane;
    }

    public abstract Plane createPlane(String[] stringData);
}
