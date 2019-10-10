package com.epam.project.task02.factory;

import com.epam.project.task02.model.Plane;
import com.epam.project.task02.model.PlaneType;

public abstract class PlaneFactory {

    public final Plane getPlane(String[] stringData) {
        Plane plane = createPlane(stringData[5]);

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

    public abstract Plane createPlane(String string);
}
