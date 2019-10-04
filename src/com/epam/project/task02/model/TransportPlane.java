package com.epam.project.task02.model;

public class TransportPlane extends Plane {

    private int maxCargo;

    public TransportPlane() {
    }

    @Override
    public int getPassenger() {
        return 0;
    }

    @Override
    public int getCargo() {
        return getMaxCargo();
    }

    public int getMaxCargo() {
        return maxCargo;
    }

    public void setMaxCargo(int maxCargo) {
        this.maxCargo = maxCargo;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && o.getClass() == getClass()) {
            TransportPlane that = (TransportPlane) o;
            return getMaxCargo() == that.getMaxCargo();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 3 + getMaxCargo();
    }

    @Override
    public String toString() {
        return super.toString() + "maxCargo= " + getMaxCargo();
    }
}
