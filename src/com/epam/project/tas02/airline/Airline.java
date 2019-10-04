package com.epam.project.tas02.airline;

import com.epam.project.tas02.comparator.*;
import com.epam.project.tas02.loader.Loader;
import com.epam.project.tas02.model.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airline {
    private static Airline airline;
    private static List<Plane> planes;
    private String nameCompany;


    static {
        planes = Loader.loadData();
    }

    private Airline(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public static Airline getInstance(String nameCompany) {
        if (airline == null) {
            airline = new Airline(nameCompany);
        }
        return airline;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Plane> findPlanesByFuel(int minFuelConsumption, int maxFuelConsumption) {
        return planes.stream()
                .filter(plane -> plane.getFuelConsumption() >= minFuelConsumption
                        && plane.getFuelConsumption() <= maxFuelConsumption)
                .collect(Collectors.toList());
    }

    public int countMaxPassengers() {
        return planes.stream()
                .mapToInt(Plane::getPassenger)
                .sum();
    }

    public int countMaxCargo() {
        return planes.stream()
                .mapToInt(Plane::getCargo)
                .sum();
    }

    public void sortByType() {
        Collections.sort(planes, new ComparatorPlaneType());
    }

    public void sortByNameBord() {
        Collections.sort(planes, new ComparatorPlaneName());
    }

    public void sortByMaxDistance() {
        Collections.sort(planes, new ComparatorPlaneMaxDistance());
    }

    public void sortBySpeed() {
        Collections.sort(planes, new ComparatorPlaneSpeed());
    }

    public void sortByFuelConsumption() {
        Collections.sort(planes, new ComparatorPlaneFuelConsumption());
    }

    //sorted the first by max->min Passengers and max->minCargo then max->min Distance
    public void sortByCargoPassengerDistance() {
        Comparator comparator = Comparator.comparing(Plane::getCargo, Comparator.reverseOrder())
                .thenComparing(Plane::getPassenger, Comparator.reverseOrder())
                .thenComparing(Plane::getMaxDistance, Comparator.reverseOrder());
        Collections.sort(planes, comparator);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("nameCompany='" + nameCompany + "'");
        planes.forEach(plane -> stringJoiner.add(plane.toString()));
        return stringJoiner.toString();
    }
}