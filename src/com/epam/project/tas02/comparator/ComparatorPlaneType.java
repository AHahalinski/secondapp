package com.epam.project.tas02.comparator;

import com.epam.project.tas02.model.Plane;
import com.epam.project.tas02.validator.ValidatorNull;

import java.util.Comparator;

public class ComparatorPlaneType implements Comparator<Plane> {
    @Override
    public int compare(Plane o1, Plane o2) {
        ValidatorNull.isNotNull(o1, o2);
        return o1.getType().compareTo(o2.getType());
    }
}
