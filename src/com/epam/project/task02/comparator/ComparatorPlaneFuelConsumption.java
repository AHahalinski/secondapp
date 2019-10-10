package com.epam.project.task02.comparator;

import com.epam.project.task02.model.Plane;

import java.util.Comparator;

public class ComparatorPlaneFuelConsumption implements Comparator<Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        return Integer.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
    }
}
