package com.epam.project.task02.model;

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
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;

        Plane plane = (Plane) o;

        if (getMaxDistance() != plane.getMaxDistance()) return false;
        if (getSpeed() != plane.getSpeed()) return false;
        if (getFuelConsumption() != plane.getFuelConsumption()) return false;
        if (getType() != plane.getType()) return false;
        return getBoardName() != null ? getBoardName().equals(plane.getBoardName()) : plane.getBoardName() == null;
    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + (getBoardName() != null ? getBoardName().hashCode() : 0);
        result = 31 * result + getMaxDistance();
        result = 31 * result + getSpeed();
        result = 31 * result + getFuelConsumption();
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
