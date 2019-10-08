package com.epam.project.task02.model;


public class PassengerPlane extends Plane {

    private int maxPassengers;

    public PassengerPlane() {
    }

    @Override
    public int getPassenger() {
        return getMaxPassengers();
    }

    @Override
    public int getCargo() {
        return 0;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && o.getClass() == getClass()) {
            PassengerPlane passengerPlane = (PassengerPlane) o;
            return getMaxPassengers() == passengerPlane.getMaxPassengers();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + maxPassengers;
    }

    @Override
    public String toString() {
        return super.toString() + "maxPassengers= " + maxPassengers;
    }
}
