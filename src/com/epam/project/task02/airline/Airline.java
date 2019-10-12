package com.epam.project.task02.airline;

import com.epam.project.task02.comparator.ComparatorPlaneMaxDistance;
import com.epam.project.task02.comparator.ComparatorPlaneFuelConsumption;
import com.epam.project.task02.comparator.ComparatorPlaneName;
import com.epam.project.task02.comparator.ComparatorPlaneSpeed;
import com.epam.project.task02.comparator.ComparatorPlaneType;
import com.epam.project.task02.model.Plane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Airline {

    private static volatile Airline instance;
    private List<Plane> planes;
    private String nameCompany;
    private static Logger logger = LogManager.getLogger(Airline.class.getName());

    private Airline(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public static Airline getInstance(String nameCompany) {
        Airline localInstance = instance;

        if (localInstance == null) {
            synchronized (Airline.class) {
                localInstance = instance;

                if (localInstance == null) {
                    instance = localInstance = new Airline(nameCompany);
                }
            }
        }
        logger.info("Create 'Airline'");
        return localInstance;
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
        logger.info("set List<Plane>");
    }

    public List<Plane> findPlanesByFuel(int minFuelConsumption, int maxFuelConsumption) {
        logger.info("find planes with fuel between min=" + minFuelConsumption + " and max=" + maxFuelConsumption);
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
        planes.sort(new ComparatorPlaneType());
    }

    public void sortByNameBord() {
        planes.sort(new ComparatorPlaneName());
    }

    public void sortByMaxDistance() {
        planes.sort(new ComparatorPlaneMaxDistance());
    }

    public void sortBySpeed() {
        planes.sort(new ComparatorPlaneSpeed());
    }

    public void sortByFuelConsumption() {
        logger.info("method sortByFuelConsumption()");
        planes.sort(new ComparatorPlaneFuelConsumption());
    }

    public void sortByCargoPassengerDistance() {
        logger.info("method sortByCargoPassengerDistance()");
        Comparator comparator = Comparator.comparing(Plane::getCargo, Comparator.reverseOrder())
                .thenComparing(Plane::getPassenger, Comparator.reverseOrder())
                .thenComparing(Plane::getMaxDistance, Comparator.reverseOrder());
        planes.sort(comparator);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("nameCompany='" + nameCompany + "'");
        planes.forEach(plane -> stringJoiner.add(plane.toString()));
        return stringJoiner.toString();
    }
}
