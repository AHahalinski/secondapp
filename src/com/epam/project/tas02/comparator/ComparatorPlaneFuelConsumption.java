package com.epam.project.tas02.comparator;

import com.epam.project.tas02.model.Plane;
import com.epam.project.tas02.validator.ValidatorNull;

import java.util.Comparator;

public class ComparatorPlaneFuelConsumption implements Comparator<Plane> {
    @Override
    public int compare(Plane o1, Plane o2) {
        ValidatorNull.isNotNull(o1, o2);
        return Integer.compare(o1.getFuelConsumption(), o2.getFuelConsumption());
    }
}
