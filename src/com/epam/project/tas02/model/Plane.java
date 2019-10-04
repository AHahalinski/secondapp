package com.epam.project.tas02.model;

import java.util.StringJoiner;

public abstract class Plane {

    private PlaneType type;
    private String boardName;
    private int maxDistance;
    private int speed;
    private int fuelConsumption;

    public Plane() {
    }

    public PlaneType getType() {
        return type;
    }

    public void setType(PlaneType type) {
        this.type = type;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public abstract int getPassenger();

    public abstract int getCargo();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof Plane)) {
            return false;
        }

        Plane plane = (Plane) o;

        return getMaxDistance() == plane.getMaxDistance() &&
                getSpeed() == plane.getSpeed() &&
                plane.getFuelConsumption() == getFuelConsumption() &&
                getType() == plane.getType() &&
                getBoardName().equals(plane.getBoardName());
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result + prime * getType().hashCode();
        result = result * prime + getBoardName().hashCode();
        result = result * prime + getMaxDistance();
        result = result * prime + getSpeed();
        result = result * prime + getFuelConsumption();

        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner("\t")
                .add("type=" + type)
                .add("boardName='" + boardName + "'")
                .add("maxDistance=" + maxDistance)
                .add("speed=" + speed)
                .add("fuelConsumption=" + fuelConsumption + "\t")
                .toString();
    }
}
