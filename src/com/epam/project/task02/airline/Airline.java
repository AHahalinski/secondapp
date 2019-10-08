package com.epam.project.task02.airline;

import com.epam.project.task02.comparator.ComparatorPlaneMaxDistance;
import com.epam.project.task02.comparator.ComparatorPlaneFuelConsumption;
import com.epam.project.task02.comparator.ComparatorPlaneName;
import com.epam.project.task02.comparator.ComparatorPlaneSpeed;
import com.epam.project.task02.comparator.ComparatorPlaneType;
import com.epam.project.task02.model.Plane;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.stream.Collectors;


public class Airline {
    private static Airline airline;
    private static List<Plane> planes;
    private String nameCompany;

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

    //sorted the first by Passengers (max->min)  and Cargo (max->min) then Distance (max->min)
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
